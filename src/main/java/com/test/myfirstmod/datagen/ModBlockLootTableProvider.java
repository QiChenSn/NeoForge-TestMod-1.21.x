package com.test.myfirstmod.datagen;

import com.test.myfirstmod.Item.ModItems;
import com.test.myfirstmod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.XIANGLU.get());
        dropSelf(ModBlocks.NAILONG.get());
        //实现自定义凋落物
        //add(ModBlocks.ORE.get(),block -> createOreDrop(ModBlocks.ORE.get(), ModItems.ORE_DROP.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        //获取所有使用BLOCK注册的方块
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
