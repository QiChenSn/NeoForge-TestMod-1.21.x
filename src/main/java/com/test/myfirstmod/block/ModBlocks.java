package com.test.myfirstmod.block;

import com.sun.jna.WString;
import com.test.myfirstmod.Item.ModFoodProperties;
import com.test.myfirstmod.Item.ModItems;
import com.test.myfirstmod.qichenstestmod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

//注册方块
public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS=DeferredRegister.createBlocks(qichenstestmod.MODID);

    //设置方块属性
    public static final DeferredBlock<Block> XIANGLU =registerBlock("xianglu",()->
            new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE))
    );

    public static final DeferredBlock<Block> NAILONG=registerBlock("nailong",()->
            new Block(BlockBehaviour.Properties.of()
                    .strength(1f)
                    .sound(SoundType.AMETHYST)){
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.qichenstestmod.nailong"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            }
    );

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    //注册方块对应物品
    private static <T extends Block>void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name,
                () -> new BlockItem(block.get(),new Item.Properties()));
    }

    //注册方法,传递事件总线
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
