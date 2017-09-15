package uk.co.yogadb.craftlab.dingcraft.items;

import net.minecraft.item.ItemFood;
import uk.co.yogadb.craftlab.dingcraft.Dingcraft;
import uk.co.yogadb.craftlab.dingcraft.Reference;
/*
 * Basic food item
 */
public class ItemCracker extends ItemFood {
    public ItemCracker() {
        // amount: amount of half hearts to heal
        // saturation: length of time the food lasts
        // wolf food: can be fed to wolves
        super(1, false);
        setUnlocalizedName(Reference.DingcraftFoodItems.CRACKER.getUnlocalizedName());
        setRegistryName(Reference.DingcraftFoodItems.CRACKER.getRegistryName());
        setCreativeTab(Dingcraft.DINGCRAFT_FOOD_TAB);
    }
}
