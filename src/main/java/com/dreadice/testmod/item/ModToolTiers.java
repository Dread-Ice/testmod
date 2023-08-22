package com.dreadice.testmod.item;

import com.dreadice.testmod.testmod;
import com.dreadice.testmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {

    public static final Tier TOTEMIC = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2700, 10f,5f, 20,
                    ModTags.Blocks.NEEDS_TOTEMIC_TOOL, () -> Ingredient.of(modItems.TOTEM_SHARD.get())),
            new ResourceLocation(testmod.MOD_ID, "totemic"), List.of(Tiers.NETHERITE), List.of());
}
