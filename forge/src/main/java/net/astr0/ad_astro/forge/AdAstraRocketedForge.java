package net.astr0.ad_astro.forge;

import net.astr0.ad_astro.common.tags.AdAstraRocketed;
import net.astr0.ad_astro.client.forge.AdAstraRocketedClientForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(AdAstraRocketed.MOD_ID)
public class AdAstraRocketedForge {

    public AdAstraRocketedForge() {
        AdAstraRocketed.init();

        if (FMLEnvironment.dist.isClient()) AdAstraRocketedClientForge.init();
    }

}
