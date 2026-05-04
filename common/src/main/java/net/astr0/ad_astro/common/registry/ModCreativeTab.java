package net.astr0.ad_astro.common.registry;

import net.astr0.ad_astro.common.tags.AdAstraRocketed;
import com.teamresourceful.resourcefullib.common.item.tabs.ResourcefulCreativeTab;
import earth.terrarium.adastra.common.registry.ModFluids;
import earth.terrarium.adastra.common.utils.FluidUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModCreativeTab {

    public static final Supplier<CreativeModeTab> TAB = new ResourcefulCreativeTab(new ResourceLocation(AdAstraRocketed.MOD_ID, "main"))
            .setItemIcon(ModItems.TIER_5_ROCKET)
            .addContent(ModCreativeTab::getCustomNbtItems)
            .addRegistry(ModItems.ITEMS)
            .build();


    public static Stream<ItemStack> getCustomNbtItems() {
        List<ItemStack> list = new ArrayList<>();


        // Add items directly and filling them with any fluid.
        list.add(FluidUtils.fluidFilledItem(ModItems.TIER_5_ROCKET, ModFluids.FUEL));
        list.add(FluidUtils.fluidFilledItem(ModItems.TIER_6_ROCKET, ModFluids.FUEL));
        list.add(FluidUtils.fluidFilledItem(ModItems.TIER_7_ROCKET, ModFluids.FUEL));


        // Add items directly without filling them with any fluid.
//        list.add(new ItemStack(ModItems.TIER_5_ROCKET.get()));
//        list.add(new ItemStack(ModItems.TIER_6_ROCKET.get()));
//        list.add(new ItemStack(ModItems.TIER_7_ROCKET.get()));


        return list.stream();
    }

    public static void init() {}
}
