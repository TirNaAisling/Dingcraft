package uk.co.yogadb.craftlab.dingcraft.items;

import net.minecraft.item.ItemFood;
import uk.co.yogadb.craftlab.dingcraft.Dingcraft;
import uk.co.yogadb.craftlab.dingcraft.Reference;
/*
 * Food item crafted from other food items giving enhanced food effects
 */
public class ItemSteakSandwich extends ItemFood {
    public ItemSteakSandwich() {
        // amount: amount of half hearts to heal
        // saturation: length of time the food lasts
        // wolf food: can be fed to wolves
        super(5, true);
        setUnlocalizedName(Reference.DingcraftFoodItems.STEAK_SANDWICH.getUnlocalizedName());
        setRegistryName(Reference.DingcraftFoodItems.STEAK_SANDWICH.getRegistryName());
        setCreativeTab(Dingcraft.DINGCRAFT_FOOD_TAB);
    }

}
