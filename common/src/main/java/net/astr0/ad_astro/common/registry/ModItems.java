package net.astr0.ad_astro.common.registry;

import net.astr0.ad_astro.common.tags.AdAstraRocketed;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.adastra.common.items.vehicles.RocketItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(BuiltInRegistries.ITEM, AdAstraRocketed.MOD_ID);

    public static final ResourcefulRegistry<Item> VEHICLES = ResourcefulRegistries.create(ITEMS);

    public static final RegistryEntry<Item> TIER_5_ROCKET = VEHICLES.register("tier_5_rocket", () -> new RocketItem(ModEntityTypes.TIER_5_ROCKET::get, new Item.Properties().stacksTo(1).fireResistant()));
    public static final RegistryEntry<Item> TIER_6_ROCKET = VEHICLES.register("tier_6_rocket", () -> new RocketItem(ModEntityTypes.TIER_6_ROCKET::get, new Item.Properties().stacksTo(1).fireResistant()));
    public static final RegistryEntry<Item> TIER_7_ROCKET = VEHICLES.register("tier_7_rocket", () -> new RocketItem(ModEntityTypes.TIER_7_ROCKET::get, new Item.Properties().stacksTo(1).fireResistant()));
}
