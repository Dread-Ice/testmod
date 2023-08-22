package com.dreadice.testmod.datagen.loot;

import com.dreadice.testmod.block.modBlock;
import com.dreadice.testmod.item.modItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Iterator;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.add(modBlock.TOTEM_SHARD_ORE.get(),
                block -> createOreDrop(modBlock.TOTEM_SHARD_ORE.get(),modItems.TOTEM_SHARD.get()));

        this.add(modBlock.TOTEM_BLOCK.get(),
                block -> createTotemBlockDrops(modBlock.TOTEM_BLOCK.get(),modItems.TOTEM_SHARD.get()));
    }

    protected LootTable.Builder createTotemBlockDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return modBlock.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
