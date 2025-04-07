package com.test.myfirstmod.Item;

import com.test.myfirstmod.ExampleMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

//注册物品
public class ModItems {
    public static final DeferredRegister.Items ITEMS=DeferredRegister.createItems(ExampleMod.MODID);

    public static final DeferredItem<Item> YUPAI= ITEMS.register("yupai",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
