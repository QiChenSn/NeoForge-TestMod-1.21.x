package com.test.myfirstmod.Item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

//自定义食物类
public class ModFoodProperties {
    //提供3点饱食度和跳跃提升效果
    public static final FoodProperties LONGKUAI=new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(()->new MobEffectInstance(MobEffects.JUMP,400),0.35f).build();
}
