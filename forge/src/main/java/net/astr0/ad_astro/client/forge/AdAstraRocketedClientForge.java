package net.astr0.ad_astro.client.forge;

import com.mojang.logging.LogUtils;
import net.astr0.ad_astro.client.AdAstraRocketedClient;
import earth.terrarium.adastra.client.forge.AdAstraClientForge;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterTextureAtlasSpriteLoadersEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.CompositeModel;
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

    @SubscribeEvent
    public static void onRegisterAdditional(ModelEvent.RegisterAdditional event) {
        // We use a standard ResourceLocation here because we are pointing to a FILE.
        event.register(new ResourceLocation("ad_astro", "entity/saturn_v"));
    }

    @SubscribeEvent
    public static void onBakingCompleted(ModelEvent.BakingCompleted event) {
        // event.getModels() returns a Map<ResourceLocation, BakedModel>
        // This matches your log exactly! No ModelResourceLocation needed.
        BakedModel model = event.getModels().get(new ResourceLocation("ad_astro", "entity/saturn_v"));
        AdAstraRocketedClient.registerRocketModel(model);

        if (model == null) {
            LogUtils.getLogger().warn("CRITICAL: Saturn V model failed to bake!");
        }
    }

}
