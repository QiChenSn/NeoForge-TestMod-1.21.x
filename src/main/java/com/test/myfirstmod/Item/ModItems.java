package com.test.myfirstmod.Item;

import com.test.myfirstmod.Item.custom.NailongMakerItem;
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
    public static final DeferredItem<Item> NAILONG_FRAGMENT= ITEMS.register("nailong_fragment",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NAILONG_MAKER= ITEMS.register("nailong_maker",
            () -> new NailongMakerItem(new Item.Properties().durability(99)));
    //注册方法,传递事件总线
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
