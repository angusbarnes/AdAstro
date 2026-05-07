package net.astr0.ad_astro.common.registry;

import net.astr0.ad_astro.common.entities.AdAstroRocket;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.adastra.AdAstra;
import earth.terrarium.adastra.common.entities.vehicles.Rocket;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntityTypes {
    public static final ResourcefulRegistry<EntityType<?>> ENTITY_TYPES = ResourcefulRegistries.create(BuiltInRegistries.ENTITY_TYPE, AdAstra.MOD_ID);

    public static final RegistryEntry<EntityType<Rocket>> TIER_5_ROCKET = ENTITY_TYPES.register("tier_5_rocket", () ->
        EntityType.Builder.<Rocket>of(AdAstroRocket::new, MobCategory.MISC)
            .fireImmune()
            .clientTrackingRange(10)
            .sized(1.1f, 7.0f)
            .build("tier_5_rocket"));

    public static final RegistryEntry<EntityType<Rocket>> TIER_6_ROCKET = ENTITY_TYPES.register("tier_6_rocket", () ->
        EntityType.Builder.<Rocket>of(AdAstroRocket::new, MobCategory.MISC)
            .fireImmune()
            .clientTrackingRange(10)
            .sized(1.1f, 7.0f)
            .build("tier_6_rocket"));

    public static final RegistryEntry<EntityType<Rocket>> TIER_7_ROCKET = ENTITY_TYPES.register("tier_7_rocket", () ->
        EntityType.Builder.<Rocket>of(AdAstroRocket::new, MobCategory.MISC)
            .fireImmune()
            .clientTrackingRange(15)
            .sized(4f, 40.0f)
            .build("tier_7_rocket"));
}
