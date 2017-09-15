package uk.co.yogadb.craftlab.dingcraft.proxy;

import net.minecraftforge.common.MinecraftForge;
import uk.co.yogadb.craftlab.dingcraft.event.PlayerEvents;
import uk.co.yogadb.craftlab.dingcraft.init.ModItems;

public class ClientProxy implements CommonProxy{
    @Override
    public void init() {
        ModItems.registerRenders();
        //ModBlocks.registerRenders();

        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJar.class, new RendererJar());
        MinecraftForge.EVENT_BUS.register(new PlayerEvents());
        //TERRAIN_GEN_BUS exception for pre and post use EVENT_BUS
        //ORE_GEN_BUS
    }

    @Override
    public void postInit() {
    }
}
