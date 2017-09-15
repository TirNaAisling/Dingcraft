package uk.co.yogadb.craftlab.dingcraft.items;

import net.minecraft.item.ItemFood;
import uk.co.yogadb.craftlab.dingcraft.Dingcraft;
import uk.co.yogadb.craftlab.dingcraft.Reference;
/*
 * Basic food item crafted from a cheese round
 */
public class ItemCheeseSlice extends ItemFood {
    public ItemCheeseSlice() {
        // amount: amount of half hearts to heal
        // saturation: length of time the food lasts
        // wolf food: can be fed to wolves
        super(2, true);
        setUnlocalizedName(Reference.DingcraftFoodItems.CHEESE_SLICE.getUnlocalizedName());
        setRegistryName(Reference.DingcraftFoodItems.CHEESE_SLICE.getRegistryName());
        setCreativeTab(Dingcraft.DINGCRAFT_FOOD_TAB);
    }
}
