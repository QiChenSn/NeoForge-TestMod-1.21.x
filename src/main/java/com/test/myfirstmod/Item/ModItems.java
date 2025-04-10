package com.test.myfirstmod.Item;

import com.test.myfirstmod.qichenstestmod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

//注册物品
public class ModItems {
    public static final DeferredRegister.Items ITEMS=DeferredRegister.createItems(qichenstestmod.MODID);

    //创建实例
    public static final DeferredItem<Item> YUPAI= ITEMS.register("yupai",
            () -> new Item(new Item.Properties()));

    //注册方法,传递事件总线
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
