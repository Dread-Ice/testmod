package com.dreadice.testmod.datagen;

import com.dreadice.testmod.block.modBlock;
import com.dreadice.testmod.testmod;
import com.dreadice.testmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, testmod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(modBlock.TOTEM_BLOCK.get(),modBlock.TOTEM_SHARD_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL).add(modBlock.TOTEM_BLOCK.get());
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(modBlock.TOTEM_SHARD_ORE.get());
        this.tag(ModTags.Blocks.NEEDS_TOTEMIC_TOOL)
                .add(Blocks.REINFORCED_DEEPSLATE);
    }
}
