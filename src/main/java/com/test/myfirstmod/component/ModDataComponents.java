package com.test.myfirstmod.component;

import com.test.myfirstmod.qichenstestmod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.UnaryOperator;

//自定义DataComponent类
public class ModDataComponents{
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES=
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE,qichenstestmod.MODID);

    //自定义DataComponent组件,类型为BlockPos,用于储存方块坐标
    //name只能是小写字母
    public static final DeferredHolder<DataComponentType<?>,DataComponentType<BlockPos>>lastPos=register("lastpos"
    ,builder->builder.persistent(BlockPos.CODEC));

    private static <T>DeferredHolder<DataComponentType<?>,DataComponentType<T>>register(String name
    , UnaryOperator<DataComponentType.Builder<T>>builderOperator){
        return DATA_COMPONENT_TYPES.register(name,()->builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus){
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}
