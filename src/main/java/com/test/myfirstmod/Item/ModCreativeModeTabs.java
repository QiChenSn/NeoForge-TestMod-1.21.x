package com.test.myfirstmod.Item;

import com.test.myfirstmod.block.ModBlocks;
import com.test.myfirstmod.qichenstestmod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

//自定义物品栏标签
public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB=
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, qichenstestmod.MODID);

    //创建一个物品栏标签
    public static final Supplier<CreativeModeTab> ALL_TAB = CREATIVE_MODE_TAB.register("all_tab",
            ()->CreativeModeTab.builder().icon(()->new ItemStack(ModBlocks.NAILONG))
                    //可以选择指定标签的位置
                    // .withTabsBefore(ResourceLocation.fromNamespaceAndPath(qichenstestmod.MODID,"TAB_NAME"))
                    .title(Component.translatable("creativetab.qichenstestmod.all_tab"))
                    .displayItems((ItemDisplayParameters,output)->{
                        output.accept(ModBlocks.XIANGLU);
                        output.accept(ModBlocks.NAILONG);
                        output.accept(ModItems.YUPAI);
                        output.accept(ModItems.NAILONG_FRAGMENT);
                        output.accept(ModItems.NAILONG_MAKER);
    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
