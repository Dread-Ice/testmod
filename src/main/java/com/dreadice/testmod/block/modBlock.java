package com.dreadice.testmod.block;

import com.dreadice.testmod.item.modItems;
import com.dreadice.testmod.testmod;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

public class modBlock {

    public static ToIntFunction<BlockState> TotemBlockLevel= BlockState -> 7;
    //Function to make the Totem Bock's Light Level 7
    public static ToIntFunction<BlockState> TotemShardOreLevel= BlockState -> 3;

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, testmod.MOD_ID);

    public static final RegistryObject<Block> TOTEM_BLOCK = registerBlock("totem_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)
                    .sound(SoundType.LODESTONE)
                    .lightLevel(TotemBlockLevel)));

    public static final RegistryObject<Block> TOTEM_SHARD_ORE = registerBlock("totem_shard_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(TotemShardOreLevel), UniformInt.of(5, 9)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return modItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
