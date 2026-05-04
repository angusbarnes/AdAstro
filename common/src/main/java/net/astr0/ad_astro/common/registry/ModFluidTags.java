package net.astr0.ad_astro.common.registry;

import net.astr0.ad_astro.common.tags.AdAstraRocketed;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public class ModFluidTags {
    public static final TagKey<Fluid> TIER_5_ROCKET_FUEL = tag("tier_5_rocket_fuel");
    public static final TagKey<Fluid> TIER_6_ROCKET_FUEL = tag("tier_6_rocket_fuel");
    public static final TagKey<Fluid> TIER_7_ROCKET_FUEL = tag("tier_7_rocket_fuel");

    private static TagKey<Fluid> tag(String name) {
        return TagKey.create(Registries.FLUID, new ResourceLocation(AdAstraRocketed.MOD_ID, name));
    }
}
