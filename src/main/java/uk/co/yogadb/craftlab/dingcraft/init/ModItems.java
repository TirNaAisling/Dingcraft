package uk.co.yogadb.craftlab.dingcraft.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import uk.co.yogadb.craftlab.dingcraft.items.*;

/*
 * Setup all mod items
 */
public class ModItems {
    public static Item cheese;
    public static Item cheese_cracker;
    public static  Item cheese_slice;
    public static Item cracker;
    public static Item steak_sandwich;

    // Instantiate the items
    public static void init(){
        cheese = new ItemCheese();
        cheese_cracker = new ItemCheeseCracker();
        cheese_slice = new ItemCheeseSlice();
        cracker = new ItemCracker();
        steak_sandwich = new ItemSteakSandwich();
    }

    // Register items with the game
    public static void register(){
        GameRegistry.register(cheese);
        GameRegistry.register(cheese_cracker);
        GameRegistry.register(cheese_slice);
        GameRegistry.register(cracker);
        GameRegistry.register(steak_sandwich);
    }

    // Register the render for each item
    public static void registerRenders(){
        registerRender(cheese);
        registerRender(cheese_cracker);
        registerRender(cheese_slice);
        registerRender(cracker);
        registerRender(steak_sandwich);
    }

    // Register render utility method
    public static void registerRender(Item item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
