package net.celsiusqc.ad_astra_rocketed.client.forge;

import net.astr0.ad_astro.client.AdAstraRocketedClient;
import earth.terrarium.adastra.client.forge.AdAstraClientForge;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AdAstraRocketedClientForge {
    public static void init() {}

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(AdAstraRocketedClient::init);
        AdAstraRocketedClient.onRegisterItemRenderers(AdAstraClientForge.ITEM_RENDERERS::put);
    }

    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        AdAstraRocketedClient.onRegisterEntityLayers(event::registerLayerDefinition);
    }
}
