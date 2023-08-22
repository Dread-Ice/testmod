package com.dreadice.testmod.util;

import com.dreadice.testmod.testmod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> NEEDS_TOTEMIC_TOOL = tag("needs_totemic_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(testmod.MOD_ID, name));
        }

    }

    public static TagKey<Item> tag(String name) {
        return ItemTags.create(new ResourceLocation(testmod.MOD_ID, name));
    }
}
