package com.test.myfirstmod.datagen;

import com.test.myfirstmod.Item.ModItems;
import com.test.myfirstmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        //添加有序合成配方
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NAILONG_MAKER.get())
                .pattern("GSG")
                .pattern("SMS")
                .pattern("GSG")
                .define('M', Items.MILK_BUCKET)
                .define('S',Items.SUGAR)
                .define('G',Items.GOLD_INGOT)
                //可以在save方法中添加参数:id,以区分相同输出的配方
                .unlockedBy("has_gold_ingot",has(Items.GOLD_INGOT)).save(recipeOutput);

        //添加无序合成配方
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModBlocks.NAILONG.get(),1)
                .requires(ModItems.NAILONG_FRAGMENT,9)
                .unlockedBy("has_nailong_fragment",has(ModItems.NAILONG_FRAGMENT)).save(recipeOutput);
    }
}
