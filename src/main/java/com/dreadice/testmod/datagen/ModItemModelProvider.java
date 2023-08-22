package com.dreadice.testmod.datagen;

import com.dreadice.testmod.item.modItems;
import com.dreadice.testmod.testmod;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, testmod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(modItems.TOTEM_DUST);
        simpleItem(modItems.TOTEM_DUST);
        simpleItem(modItems.CRYSTALISED_TOTEMIC_SHARD);

        handheldItem(modItems.TOTEMIC_AXE);
        handheldItem(modItems.TOTEMIC_PICKAXE);
        handheldItem(modItems.TOTEMIC_SWORD);
        handheldItem(modItems.TOTEMIC_SHOVEL);
        handheldItem(modItems.TOTEMIC_HOE);

    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(testmod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
        new ResourceLocation("item/generated")).texture("layer0",
        new ResourceLocation(testmod.MOD_ID,"item/"+item.getId().getPath()));
    }
}
