package uk.co.yogadb.craftlab.dingcraft.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import uk.co.yogadb.craftlab.dingcraft.Reference;
import uk.co.yogadb.craftlab.dingcraft.init.ModItems;

public class DingcraftTab extends CreativeTabs {
    public DingcraftTab() {
        super(Reference.DingcraftTabs.DINGCRAFT_FOOD_TAB.getUnlocalizedName());
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.steak_sandwich);
    }
}
