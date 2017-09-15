package uk.co.yogadb.craftlab.dingcraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import uk.co.yogadb.craftlab.dingcraft.init.ModCrafting;
import uk.co.yogadb.craftlab.dingcraft.init.ModItems;
import uk.co.yogadb.craftlab.dingcraft.proxy.CommonProxy;
import uk.co.yogadb.craftlab.dingcraft.tabs.DingcraftTab;
import uk.co.yogadb.craftlab.dingcraft.util.Utils;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class Dingcraft {
    @Instance
    public static Dingcraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static CommonProxy proxy;

    public static final CreativeTabs DINGCRAFT_FOOD_TAB = new DingcraftTab();

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        ModItems.init();
        ModItems.register();

        Utils.getLogger().info("Dingcraft Mod postInit() Completed...");
    }
    @Mod.EventHandler

    public static void init(FMLInitializationEvent event){
        proxy.init();
        ModCrafting.register();
        //GameRegistry.registerTileEntity(TileEntityJar.class, Reference.MOD_ID + "TileEntityJar");

        Utils.getLogger().info("Dingcraft Mod init() Completed...");
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event){
        Utils.getLogger().info("Dingcraft Mod preInit() Completed...");
    }
}
