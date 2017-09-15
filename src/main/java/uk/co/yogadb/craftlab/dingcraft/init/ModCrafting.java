package uk.co.yogadb.craftlab.dingcraft.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/*
 * Crafting recipies for mod items, blocs and devices
 */
public class ModCrafting {
    public static void register(){
        //Blocks
        //GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.cheese), "CCC", "CCC", "CCC", 'C', ModItems.cheese);
        //GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.jar), " W ", "GGG", "WWW", 'W', Blocks.PLANKS, 'G', new ItemStack(Blocks.STAINED_GLASS, 1, 5));

        //Food
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cheese), "MMM", "MMM", "MMM", 'M', Items.MILK_BUCKET);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cracker, 2), "WWW", "WWW", 'W', Items.WHEAT);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cheese_slice, 18), "C", 'C', ModItems.cheese);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cheese_cracker), "B", "C", "B", 'C', ModItems.cheese_slice, 'B', ModItems.cracker);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cheese_cracker), "BCB", 'C', ModItems.cheese_slice, 'B', ModItems.cracker);

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.steak_sandwich), "B", "C", "B", 'C', Items.COOKED_BEEF, 'B', Items.BREAD);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.steak_sandwich), "BCB", 'C', Items.COOKED_BEEF, 'B', Items.BREAD);
    }
}
