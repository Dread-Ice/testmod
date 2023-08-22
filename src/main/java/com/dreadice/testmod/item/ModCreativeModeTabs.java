package com.dreadice.testmod.item;

import com.dreadice.testmod.block.modBlock;
import com.dreadice.testmod.testmod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
             DeferredRegister.create(Registries.CREATIVE_MODE_TAB, testmod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TEST_TAB = CREATIVE_MODE_TABS.register("test_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.TOTEM_OF_UNDYING))
                    .title(Component.translatable("creativetab.test_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Items.TOTEM_OF_UNDYING);
                        pOutput.accept(modBlock.TOTEM_BLOCK.get());
                        pOutput.accept(modBlock.TOTEM_SHARD_ORE.get());
                        pOutput.accept(modItems.TOTEM_SHARD.get());
                        pOutput.accept(modItems.CRYSTALISED_TOTEMIC_SHARD.get());
                        pOutput.accept(modItems.TOTEM_DUST.get());
                        pOutput.accept(modItems.TOTEMIC_SHOVEL.get());
                        pOutput.accept(modItems.TOTEMIC_PICKAXE.get());
                        pOutput.accept(modItems.TOTEMIC_AXE.get());
                        pOutput.accept(modItems.TOTEMIC_HOE.get());
                        pOutput.accept(modItems.TOTEMIC_SWORD.get());
                    })
                    .build());

    public static  void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
