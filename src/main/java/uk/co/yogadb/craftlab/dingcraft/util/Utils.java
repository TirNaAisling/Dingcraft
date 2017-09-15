package uk.co.yogadb.craftlab.dingcraft.util;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.co.yogadb.craftlab.dingcraft.Reference;

public class Utils {
    private static Logger logger;

    /*
     Text Logger for console messages
     */
    public static Logger getLogger() {
        if(logger == null){
            logger = LogManager.getFormatterLogger(Reference.MOD_ID);
        }
        return logger;
    }

    public static ItemStack addStackToInventory(IItemHandler handler, ItemStack stack, boolean simulate) {
        ItemStack remainder = stack;
        for(int slot = 0; slot < handler.getSlots(); slot++) {
            remainder = handler.insertItem(slot, stack, simulate);
            if(remainder == ItemStack.EMPTY) break;
        }
        return remainder;
    }

    public static ItemStack addStackToInventory(IItemHandler handler, int maxSlot, ItemStack stack, boolean simulate) {
        ItemStack remainder = stack;
        for(int slot = 0; slot < maxSlot; slot++) {
            remainder = handler.insertItem(slot, stack, simulate);
            if(remainder == ItemStack.EMPTY) break;
        }
        return remainder;
    }

    public static boolean isInventoryFull(IItemHandler handler) {
        int filledSlots = 0;
        for(int slot = 0; slot < handler.getSlots(); slot++) {
            if(handler.getStackInSlot(slot).getCount() == handler.getSlotLimit(slot)) filledSlots++;
        }
        return filledSlots == handler.getSlots();
    }

    public static boolean isInventoryFull(IItemHandler handler, int maxSlot) {
        int filledSlots = 0;
        for(int slot = 0; slot < maxSlot; slot++) {
            if(handler.getStackInSlot(slot).getCount() == handler.getSlotLimit(slot)) filledSlots++;
        }
        return filledSlots == maxSlot;
    }

    public static EnumDyeColor getColorFromDye(ItemStack stack){
        for (int id : OreDictionary.getOreIDs(stack)){
            if (id == OreDictionary.getOreID("dyeBlack")){ return EnumDyeColor.BLACK; }
            if (id == OreDictionary.getOreID("dyeRed")){ return EnumDyeColor.RED; }
            if (id == OreDictionary.getOreID("dyeGreen")){ return EnumDyeColor.GREEN; }
            if (id == OreDictionary.getOreID("dyeBrown")){ return EnumDyeColor.BROWN; }
            if (id == OreDictionary.getOreID("dyeBlue")){ return EnumDyeColor.BLUE; }
            if (id == OreDictionary.getOreID("dyePurple")){ return EnumDyeColor.PURPLE; }
            if (id == OreDictionary.getOreID("dyeCyan")){ return EnumDyeColor.CYAN; }
            if (id == OreDictionary.getOreID("dyeSilver")){ return EnumDyeColor.SILVER; }
            if (id == OreDictionary.getOreID("dyeGray")){ return EnumDyeColor.GRAY; }
            if (id == OreDictionary.getOreID("dyePink")){ return EnumDyeColor.PINK; }
            if (id == OreDictionary.getOreID("dyeLime")){ return EnumDyeColor.LIME; }
            if (id == OreDictionary.getOreID("dyeYellow")){ return EnumDyeColor.YELLOW; }
            if (id == OreDictionary.getOreID("dyeLightBlue")){ return EnumDyeColor.LIGHT_BLUE; }
            if (id == OreDictionary.getOreID("dyeMagenta")){ return EnumDyeColor.MAGENTA; }
            if (id == OreDictionary.getOreID("dyeOrange")){ return EnumDyeColor.ORANGE; }
            if (id == OreDictionary.getOreID("dyeWhite")){ return EnumDyeColor.WHITE; }
        }
        return EnumDyeColor.WHITE;
    }

    // Initialize crafting attributes (should only be called on world join event)
    public static void initializeCraftingAttributes(NBTTagCompound entityData){
        if (!entityData.hasKey("wood_working")){ entityData.setInteger("wood_working", 0); }
        if (!entityData.hasKey("farming")){ entityData.setInteger("farming", 0); }
        if (!entityData.hasKey("cooking")){ entityData.setInteger("cooking", 0); }
        if (!entityData.hasKey("smithing")){ entityData.setInteger("smithing", 0); }
        if (!entityData.hasKey("mining")){ entityData.setInteger("mining", 0); }
    }
}
