package net.celsiusqc.ad_astra_rocketed.client.fabric;

import net.astr0.ad_astro.client.AdAstraRocketedClient;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;

public class AdAstraRocketedClientFabric {

    public static void init() {
        AdAstraRocketedClient.init();

        AdAstraRocketedClient.onRegisterItemRenderers(((item, renderer) -> BuiltinItemRendererRegistry.INSTANCE.register(item, renderer::renderByItem)));
        AdAstraRocketedClient.onRegisterEntityLayers(((location, definition) -> EntityModelLayerRegistry.registerModelLayer(location, definition::get)));
    }

}
