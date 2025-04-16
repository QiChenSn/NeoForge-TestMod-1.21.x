package com.test.myfirstmod.Item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

//自定义食物类
public class ModFoodProperties extends Item {
    //提供3点饱食度和跳跃提升效果
    public static final FoodProperties LONGKUAI=new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(()->new MobEffectInstance(MobEffects.JUMP,400),0.35f).build();

    public ModFoodProperties(Properties properties) {
        super(properties);
    }
}
