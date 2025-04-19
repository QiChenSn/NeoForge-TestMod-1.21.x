package com.test.myfirstmod.Item;

import com.test.myfirstmod.Item.custom.NailongMakerItem;
import com.test.myfirstmod.qichenstestmod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

//注册物品
public class ModItems {
    public static final DeferredRegister.Items ITEMS=DeferredRegister.createItems(qichenstestmod.MODID);

    //创建实例
    public static final DeferredItem<Item> YUPAI= ITEMS.register("yupai",
            () -> new Item(new Item.Properties()));
    //通过匿名类重写方法实现添加物品说明
    public static final DeferredItem<Item> NAILONG_FRAGMENT= ITEMS.register("nailong_fragment",
            () -> new Item(new Item.Properties()){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.qichenstestmod.nailong_fragment"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    //注意:使用自定义物品类时new的对象
    public static final DeferredItem<Item> NAILONG_MAKER= ITEMS.register("nailong_maker",
            () -> new NailongMakerItem(new Item.Properties().durability(99)));
    public static final DeferredItem<Item> LONGKUAI= ITEMS.register("longkuai",
            () -> new Item(new Item.Properties().food(ModFoodProperties.LONGKUAI)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.qichenstestmod.longkuai"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    //注册方法,传递事件总线
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
