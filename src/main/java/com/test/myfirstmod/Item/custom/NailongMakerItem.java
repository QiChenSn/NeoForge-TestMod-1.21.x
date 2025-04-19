package com.test.myfirstmod.Item.custom;

import com.test.myfirstmod.Item.ModItems;
import com.test.myfirstmod.block.ModBlocks;
import com.test.myfirstmod.component.ModDataComponents;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import javax.naming.ldap.Control;
import java.util.List;
import java.util.Map;

//创建高级物品
public class NailongMakerItem extends Item {
    public NailongMakerItem(Properties properties) {
        super(properties);
    }

    public static final Map<Block,Block> BLOCK_MAP=Map.of(
            Blocks.GLOWSTONE, ModBlocks.NAILONG.get()
    );

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level=context.getLevel();
        Block clickedBlock=level.getBlockState(context.getClickedPos()).getBlock();
        if(BLOCK_MAP.containsKey(clickedBlock)){
            //仅服务端
            if(!level.isClientSide){
                //查询Map并替换方块
                //level.setBlockAndUpdate(context.getClickedPos(),BLOCK_MAP.get(clickedBlock).defaultBlockState());
                //消耗方块并掉落物品
                InteractionHand interactionHand = context.getHand();
                if(context.getPlayer().getItemInHand(interactionHand).getItem()==(ModItems.NAILONG_MAKER.get())){
                    Block.popResource(level,context.getClickedPos(), ModItems.NAILONG_FRAGMENT.toStack(1));
                    level.removeBlock(context.getClickedPos(),false);
                    //消耗耐久值
                    context.getItemInHand().hurtAndBreak(1,(ServerLevel) level,context.getPlayer(),
                            item->context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
                    //设置点击音效
                    level.playSound(null,context.getClickedPos(), SoundEvents.VILLAGER_YES, SoundSource.BLOCKS);

                    //记录替换方块的坐标
                    context.getItemInHand().set(ModDataComponents.lastPos, context.getClickedPos());
                }
            }
        }
        //交互成功返回值
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.qichenstestmod.nailong_maker"));
        if(Screen.hasShiftDown()&&stack.get(ModDataComponents.lastPos)!=null){
            tooltipComponents.add(Component.literal("上次转换:"+stack.get(ModDataComponents.lastPos)));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

}
