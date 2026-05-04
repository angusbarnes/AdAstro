package net.astr0.ad_astro.common.tags;

import net.astr0.ad_astro.common.registry.ModCreativeTab;
import net.astr0.ad_astro.common.registry.ModEntityTypes;
import net.astr0.ad_astro.common.registry.ModItems;

public class AdAstraRocketed {
    public static final String MOD_ID = "ad_astra_rocketed";

    public static void init() {
        ModItems.ITEMS.init();
        ModCreativeTab.init();
        ModEntityTypes.ENTITY_TYPES.init();
    }

    public static void postInit() {}
}
