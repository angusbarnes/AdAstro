package net.astr0.ad_astro.client;

import net.astr0.ad_astro.common.registry.ModEntityTypes;
import net.astr0.ad_astro.client.models.entities.RocketedRocketModel;
import net.astr0.ad_astro.client.renderers.entities.AdAstraRocketedRenderer;
import net.astr0.ad_astro.common.registry.ModItems;
import earth.terrarium.adastra.client.ClientPlatformUtils;
import earth.terrarium.adastra.client.renderers.entities.vehicles.RocketRenderer;
import earth.terrarium.botarium.client.ClientHooks;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;

import java.util.function.BiConsumer;

public class AdAstraRocketedClient {

    public static void init() {
        registerEntityRenderers();
    }

    private static void registerEntityRenderers() {
        ClientHooks.registerEntityRenderer(ModEntityTypes.TIER_5_ROCKET, c -> new RocketRenderer(c, RocketedRocketModel.TIER_5_LAYER, AdAstraRocketedRenderer.TIER_5_TEXTURE));
        ClientHooks.registerEntityRenderer(ModEntityTypes.TIER_6_ROCKET, c -> new RocketRenderer(c, RocketedRocketModel.TIER_6_LAYER, AdAstraRocketedRenderer.TIER_6_TEXTURE));
        ClientHooks.registerEntityRenderer(ModEntityTypes.TIER_7_ROCKET, c -> new RocketRenderer(c, RocketedRocketModel.TIER_7_LAYER, AdAstraRocketedRenderer.TIER_7_TEXTURE));
    }

    public static void onRegisterEntityLayers(ClientPlatformUtils.LayerDefinitionRegistry consumer) {
        RocketedRocketModel.register(consumer);
    }

    public static void onRegisterItemRenderers(BiConsumer<Item, BlockEntityWithoutLevelRenderer> consumer) {
        consumer.accept(ModItems.TIER_5_ROCKET.get(), new RocketRenderer.ItemRenderer(RocketedRocketModel.TIER_5_LAYER, AdAstraRocketedRenderer.TIER_5_TEXTURE));
        consumer.accept(ModItems.TIER_6_ROCKET.get(), new RocketRenderer.ItemRenderer(RocketedRocketModel.TIER_6_LAYER, AdAstraRocketedRenderer.TIER_6_TEXTURE));
        consumer.accept(ModItems.TIER_7_ROCKET.get(), new RocketRenderer.ItemRenderer(RocketedRocketModel.TIER_7_LAYER, AdAstraRocketedRenderer.TIER_7_TEXTURE));
    }

}
