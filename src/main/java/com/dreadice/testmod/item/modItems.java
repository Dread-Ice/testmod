package com.dreadice.testmod.item;

import com.dreadice.testmod.testmod;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class modItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, testmod.MOD_ID);

    public static final RegistryObject<Item> TOTEM_SHARD = ITEMS.register("totem_shard",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CRYSTALISED_TOTEMIC_SHARD = ITEMS.register("crystalised_totemic_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOTEM_DUST = ITEMS.register("totem_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TOTEMIC_AXE = ITEMS.register("totemic_axe",
            () -> new AxeItem(ModToolTiers.TOTEMIC,5, -3, new Item.Properties()));
    public static final RegistryObject<Item> TOTEMIC_PICKAXE = ITEMS.register("totemic_pickaxe",
            () -> new PickaxeItem(ModToolTiers.TOTEMIC, 1,-2.8f, new Item.Properties()));
    public static final RegistryObject<Item> TOTEMIC_SWORD = ITEMS.register("totemic_sword",
            () -> new SwordItem(ModToolTiers.TOTEMIC, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> TOTEMIC_SHOVEL = ITEMS.register("totemic_shovel",
            () -> new ShovelItem(ModToolTiers.TOTEMIC, 1.5f,-3, new Item.Properties()));
    public static final RegistryObject<Item> TOTEMIC_HOE = ITEMS.register("totemic_hoe",
            () -> new HoeItem(ModToolTiers.TOTEMIC, -5,0, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
