package net.astr0.ad_astro.client.renderers.items;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.astr0.ad_astro.client.AdAstraRocketedClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class ObjRocketItemRenderer extends BlockEntityWithoutLevelRenderer {
    private final ResourceLocation texture;
    private final ModelResourceLocation objModelLoc;

    public ObjRocketItemRenderer(ModelResourceLocation objModelLoc, ResourceLocation texture) {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        this.texture = texture;
        this.objModelLoc = objModelLoc;
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        BakedModel bakedModel = AdAstraRocketedClient.BAKED_ROCKET_MODEL;
        var consumer = buffer.getBuffer(RenderType.entityCutoutNoCullZOffset(texture));

        poseStack.pushPose();
        try {
            // Ad Astra Item math
            poseStack.mulPose(Axis.ZP.rotationDegrees(0));
            poseStack.translate(0.0, -1.501, 0.0);

            poseStack.scale(0.0625f * 6, 0.0625f * 6, 0.0625f * 6);

            // Render the OBJ
            Minecraft.getInstance().getBlockRenderer().getModelRenderer().renderModel(
                    poseStack.last(), consumer, null, bakedModel, 1.0f, 1.0f, 1.0f, packedLight, packedOverlay
            );
        } finally {
            poseStack.popPose();
        }
    }
}
