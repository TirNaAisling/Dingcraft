package uk.co.yogadb.craftlab.dingcraft.items;

import net.minecraft.item.Item;
import uk.co.yogadb.craftlab.dingcraft.Dingcraft;
import uk.co.yogadb.craftlab.dingcraft.Reference;

/*
 Non Food item used in the crafting of cheese slices
 */
public class ItemCheese extends Item {
    public ItemCheese() {
        setUnlocalizedName(Reference.DingcraftFoodItems.CHEESE.getUnlocalizedName());
        setRegistryName(Reference.DingcraftFoodItems.CHEESE.getRegistryName());
        setCreativeTab(Dingcraft.DINGCRAFT_FOOD_TAB);
    }
}
