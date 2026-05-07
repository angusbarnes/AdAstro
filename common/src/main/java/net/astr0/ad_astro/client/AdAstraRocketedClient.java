package net.astr0.ad_astro.client;

import net.astr0.ad_astro.client.renderers.entities.ObjRocketRenderer;
import net.astr0.ad_astro.client.renderers.items.ObjRocketItemRenderer;
import net.astr0.ad_astro.common.registry.ModEntityTypes;
import net.astr0.ad_astro.client.models.entities.RocketedRocketModel;
import net.astr0.ad_astro.client.renderers.entities.AdAstraRocketedRenderer;
import net.astr0.ad_astro.common.registry.ModItems;
import earth.terrarium.adastra.client.ClientPlatformUtils;
import earth.terrarium.adastra.client.renderers.entities.vehicles.RocketRenderer;
import earth.terrarium.botarium.client.ClientHooks;
import net.astr0.ad_astro.common.tags.AdAstraRocketed;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.BiConsumer;

import static net.astr0.ad_astro.client.renderers.entities.AdAstraRocketedRenderer.SATURN_V_MRL;
import static net.astr0.ad_astro.client.renderers.entities.AdAstraRocketedRenderer.SATURN_V_OBJ_FILE;

public class AdAstraRocketedClient {

    public static BakedModel BAKED_ROCKET_MODEL = null;

    public static void registerRocketModel(BakedModel model) {
        BAKED_ROCKET_MODEL = model;
    }

    public static void init() {
        registerEntityRenderers();
    }

    private static void registerEntityRenderers() {
        ClientHooks.registerEntityRenderer(ModEntityTypes.TIER_5_ROCKET, c -> new RocketRenderer(c, RocketedRocketModel.TIER_5_LAYER, AdAstraRocketedRenderer.TIER_5_TEXTURE));
        ClientHooks.registerEntityRenderer(ModEntityTypes.TIER_6_ROCKET, c -> new RocketRenderer(c, RocketedRocketModel.TIER_6_LAYER, AdAstraRocketedRenderer.TIER_6_TEXTURE));
        ClientHooks.registerEntityRenderer(ModEntityTypes.TIER_7_ROCKET, c -> new ObjRocketRenderer(c, SATURN_V_MRL, AdAstraRocketedRenderer.SATURN_V));
    }

    public static void onRegisterEntityLayers(ClientPlatformUtils.LayerDefinitionRegistry consumer) {
        RocketedRocketModel.register(consumer);
    }

    public static void onRegisterItemRenderers(BiConsumer<Item, BlockEntityWithoutLevelRenderer> consumer) {
        consumer.accept(ModItems.TIER_5_ROCKET.get(), new RocketRenderer.ItemRenderer(RocketedRocketModel.TIER_5_LAYER, AdAstraRocketedRenderer.TIER_5_TEXTURE));
        consumer.accept(ModItems.TIER_6_ROCKET.get(), new RocketRenderer.ItemRenderer(RocketedRocketModel.TIER_6_LAYER, AdAstraRocketedRenderer.TIER_6_TEXTURE));
        consumer.accept(ModItems.TIER_7_ROCKET.get(), new ObjRocketItemRenderer(SATURN_V_MRL, AdAstraRocketedRenderer.SATURN_V));
    }

}
