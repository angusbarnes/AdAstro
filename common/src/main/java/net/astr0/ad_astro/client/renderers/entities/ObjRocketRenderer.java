package net.astr0.ad_astro.client.renderers.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.logging.LogUtils;
import com.mojang.math.Axis;
import earth.terrarium.adastra.common.entities.vehicles.Rocket;
import net.astr0.ad_astro.client.AdAstraRocketedClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ObjRocketRenderer extends EntityRenderer<Rocket> {
    private final ResourceLocation texture;
    private final ModelResourceLocation objModelLoc;

    public ObjRocketRenderer(EntityRendererProvider.Context context, ModelResourceLocation objModelLoc, ResourceLocation texture) {
        super(context);
        this.shadowRadius = 0.5f;
        this.texture = texture;
        this.objModelLoc = objModelLoc;
    }

    @Override
    public void render(Rocket entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        // Calls the base EntityRenderer to draw nameplates, hitboxes, etc.
        super.render(entity, entityYaw, partialTick, poseStack, buffer, packedLight);

        BakedModel bakedModel = AdAstraRocketedClient.BAKED_ROCKET_MODEL;
        if (bakedModel == Minecraft.getInstance().getModelManager().getMissingModel()) {
            // This tells you if the game is failing to find your OBJ and falling back to the cube
            LogUtils.getLogger().warn("DEBUG: Rocket bakedModel={} is MISSING!",objModelLoc);
        }


        poseStack.pushPose();
        try {
            // --- AD ASTRA SHAKE & POSITION MATH ---
            if (!Minecraft.getInstance().isPaused() && (entity.isLaunching() || entity.hasLaunched())) {
                entityYaw += (float) (entity.level().random.nextGaussian() * 3);
            }
            poseStack.scale(0.0625f * 6, 0.0625f * 6, 0.0625f * 6);
            poseStack.translate(0.0F, 0F, 0.0F);
            poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));
            float xRot = Mth.lerp(partialTick, entity.xRotO, entity.getXRot());
            poseStack.mulPose(Axis.ZP.rotationDegrees(-xRot));

            // NOTE ON SCALING:
            // Ad Astra scales by (-1.0F, -1.0F, 1.0F) because vanilla LayerDefinitions are rendered upside down.
            // OBJs are usually right-side up. You likely need to leave this as (1.0F, 1.0F, 1.0F).
            // If your rocket is upside down in-game, uncomment the negative scaling!
            // poseStack.scale(-1.0F, -1.0F, 1.0F);

            // --- OBJ RENDERING ---
            //VertexConsumer consumer = buffer.getBuffer(RenderType.entityCutoutNoCull(this.texture));
            VertexConsumer consumer = buffer.getBuffer(RenderType.armorCutoutNoCull(this.texture));

            Minecraft.getInstance().getBlockRenderer().getModelRenderer().renderModel(
                    poseStack.last(), consumer, null, bakedModel, 1.0F, 1.0F, 1.0F, packedLight, OverlayTexture.NO_OVERLAY
            );
        } finally {
            poseStack.popPose();
        }
    }

    @Override
    public ResourceLocation getTextureLocation(Rocket entity) {
        return texture;
    }
}