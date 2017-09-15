package uk.co.yogadb.craftlab.dingcraft.event;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import uk.co.yogadb.craftlab.dingcraft.Reference;
import uk.co.yogadb.craftlab.dingcraft.util.Utils;

public class PlayerEvents {
    @SubscribeEvent
    public void onEntityJoinWorldEvent(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof EntityLivingBase) {
            EntityLivingBase entity = (EntityLivingBase) event.getEntity();
            NBTTagCompound entityData = entity.getEntityData();

            //
            if (!event.getWorld().isRemote) {
                if (event.getEntity() instanceof EntityPlayer) { // Only for the player
                    // Initialize player health
                    setHealth(entity, 0.0F);

                    //XP to level
                    //xpToLevel(entity, entityData, event);
                    //((EntityPlayer)entity).experienceLevel =100;
                    //setEntityHealth(entity, ((EntityPlayer)entity).experienceLevel, ((EntityPlayer)entity).experienceLevel);

                    // Setup player crafting attributes
                    Utils.initializeCraftingAttributes(entityData);
                }
            }
        }
    }

    //LivingUpdateEvent

    @SubscribeEvent
    public void xp(LivingEvent.LivingUpdateEvent event){
        EntityLivingBase entity = event.getEntityLiving();
        NBTTagCompound entityData = entity.getEntityData();

        if (!entity.world.isRemote) {
            if (event.getEntity() instanceof EntityPlayer) { // Only for the player
                // Initialize player health

                event.getEntityLiving()
                ((EntityPlayer)entity).experienceL = 1;

            }
        }
    }

    public void xpToLevel(EntityLivingBase entity, NBTTagCompound entityData, EntityJoinWorldEvent event){
        if (!entityData.hasKey("level")) { // Check if this has already been set
            entityData.setFloat("level", 1.0F);
            entity.sendMessage(new TextComponentString("1"));

        }else{
            entityData.setFloat("level", ((EntityPlayer)entity).experienceLevel );
            ((EntityPlayer)entity).experience =  entityData.getFloat("level");

            entity.sendMessage(new TextComponentString("" + ((EntityPlayer)entity).experienceLevel + " " + entityData.getFloat("level") ));

            int health = Math.round(entityData.getFloat("level")*2);
            //setEntityHealth(entity, health, health);
        }
        ((EntityPlayer)entity).writeEntityToNBT(entityData); // Write the NBT to save
    }

    @SubscribeEvent
    public void playerDeath(LivingDeathEvent event){}


    @SubscribeEvent
    public void  playerRespawn(PlayerEvent.PlayerRespawnEvent event){
        setHealth(event.player, getHealth(event.player));// Reinitialize player health
    }

    public static float getHealth(EntityLivingBase player){
        NBTTagCompound entityData = player.getEntityData();
        // Ensure minimum value is 1 heart by returning 2 if level is lower than 2
        return  entityData.getFloat("level") >= Reference.MIN_LEVEL ? entityData.getFloat("level") : Reference.START_HEALTH;
    }

    // Set or Reinitialize player health
    public  void setHealth(EntityLivingBase player, float health){
        NBTTagCompound entityData = player.getEntityData();
        if (!player.world.isRemote) {
            if (!entityData.hasKey("has_health_set")) { // Check if this has already been set
                entityData.setBoolean("has_health_set", true); // Set the flag to do this once only
                player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(Reference.START_HEALTH);
                player.setHealth(Reference.START_HEALTH);
            }else{
                health = health >= Reference.START_HEALTH ? health : getHealth(player);
                player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(health);
                player.setHealth(health);
            }
        }
        player.writeEntityToNBT(entityData); // Write the NBT to save
    }

    @SubscribeEvent
    public void breakBlockEvent(BlockEvent.BreakEvent event){
        // Get the player and NBT data
        EntityLivingBase entity = event.getPlayer();
        NBTTagCompound entityData = entity.getEntityData();

        //initializeCraftingAttributes(entityData); // Initialize the crafting attributes
        Block block = event.getState().getBlock(); // Get the block being broken

        // Wood working events
        woodWorkingEvent(block, entity, entityData, event);

        //entityData.setInteger("wood_working", 0); // reset
    }

    @SubscribeEvent
    public void pickUpItem(EntityItemPickupEvent event){
        // For Oak or Birch Logs
        /*if(event.getItem().getItem().getItem() == ItemBlock.getItemFromBlock(Blocks.LOG) ){
            if (event.getItem().getItem().getMetadata() == 0){
                Utils.getLogger().info("Picked up an oak log");
            }else if (event.getItem().getItem().getMetadata() == 2){
                Utils.getLogger().info("Picked up an birch log");
            }
        }*/
    }


    protected void woodWorkingEvent(Block block, EntityLivingBase entity, NBTTagCompound entityData, BlockEvent.BreakEvent event){
        if(block == Blocks.LOG || block == Blocks.LOG2) {
            int currentLevel = entityData.getInteger("wood_working"); // Get the current level
            if(currentLevel == 0){levelUp("Woodworking", currentLevel, entity);} // Announce level 1 on first block broken

            if(block == Blocks.LOG){
                int blockType = event.getState().getBlock().getMetaFromState(event.getState());
                if(entityData.getInteger("wood_working") <= Reference.WOOD_LEVEL[0][1]) {
                    if (blockType == 0 || blockType == 2) { // Oak or Birch logs
                        currentLevel++;
                    }
                }else if (entityData.getInteger("wood_working") >= Reference.WOOD_LEVEL[1][0] && entityData.getInteger("wood_working") <= Reference.WOOD_LEVEL[1][1]){
                    if (blockType == 1) { // Spruce logs
                        currentLevel++;
                    }
                }else if (entityData.getInteger("wood_working") >= Reference.WOOD_LEVEL[3][0] && entityData.getInteger("wood_working") <= Reference.WOOD_LEVEL[3][1]){
                    if (blockType == 3) { // Jungle logs
                        currentLevel++;
                    }
                }
            }else if (block == Blocks.LOG2){
                int blockType = event.getState().getBlock().getMetaFromState(event.getState());
                if(entityData.getInteger("wood_working") >= Reference.WOOD_LEVEL[1][0] && entityData.getInteger("wood_working") <= Reference.WOOD_LEVEL[1][1]) {
                    if (blockType == 1) { // Dark Oak logs
                        currentLevel++;
                    }
                }else if (entityData.getInteger("wood_working") >= Reference.WOOD_LEVEL[2][0] && entityData.getInteger("wood_working") <= Reference.WOOD_LEVEL[2][1]){
                    if (blockType == 0) { // Acacia logs
                        currentLevel++;
                    }
                }
            }

            entityData.setInteger("wood_working", currentLevel); // Update the new value
            levelUp("Woodworking", entityData.getInteger("wood_working"), entity);
            event.getPlayer().writeEntityToNBT(entityData); // Write the NBT to save
        }
    }

    protected void levelUp(String craftingClass, int level, EntityLivingBase entity){
        switch (level){
            case 0:
                entity.sendMessage(new TextComponentString(craftingClass + " increased to level " + 1));
                break;
            case 9:
                entity.sendMessage(new TextComponentString(craftingClass + " increased to level " + 2));
                break;
            case 24:
                entity.sendMessage(new TextComponentString(craftingClass + " increased to level " + 3));
                break;
            case 49:
                entity.sendMessage(new TextComponentString(craftingClass + " increased to level " + 4));
                break;
            case 79:
                entity.sendMessage(new TextComponentString(craftingClass + " increased to level " + 5));
                break;
        }
    }
}
