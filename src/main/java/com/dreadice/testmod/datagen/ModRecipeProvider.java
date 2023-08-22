package com.dreadice.testmod.datagen;

import com.dreadice.testmod.block.modBlock;
import com.dreadice.testmod.item.modItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, List.of(modBlock.TOTEM_SHARD_ORE.get()), RecipeCategory.MISC, modItems.TOTEM_SHARD.get(), 0.25f, 200, "Totems");
        oreBlasting(pWriter, List.of(modBlock.TOTEM_SHARD_ORE.get()), RecipeCategory.MISC, modItems.TOTEM_SHARD.get(), 0.25f, 100, "Totems");

        oreBlasting(pWriter, List.of(modItems.TOTEM_SHARD.get()), RecipeCategory.MISC, modItems.TOTEM_DUST.get(), 0.25f,200, "Totems");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, modBlock.TOTEM_BLOCK.get())
                .pattern("##")
                .pattern("##")
                .define('#', modItems.TOTEM_DUST.get())
                .unlockedBy(getHasName(modItems.TOTEM_SHARD.get()), has(modItems.TOTEM_DUST.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, modItems.CRYSTALISED_TOTEMIC_SHARD.get(), 8)
                .pattern("TDT")
                .pattern("DND")
                .pattern("TDT")
                .define('N', Items.NETHER_STAR)
                .define('D', Items.DIAMOND)
                .define('T', modItems.TOTEM_SHARD.get())
                .unlockedBy(getHasName(modItems.TOTEM_DUST.get()), has(modItems.TOTEM_SHARD.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }
}
