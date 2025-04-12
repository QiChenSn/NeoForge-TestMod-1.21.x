package com.test.myfirstmod.block.custom;

import com.test.myfirstmod.Item.ModItems;
import com.test.myfirstmod.block.ModBlocks;
import net.minecraft.client.gui.screens.social.PlayerEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NaiLongBlock extends Block {

    //设置获取物品间隔
    private static int timeNeeded=20*1;
    //玩家独立计算时间
    private static final Map<UUID,Integer> playerTimer=new HashMap<>();

    public NaiLongBlock(Properties properties) {
        super(properties);
    }

    //注意要监听子类,不能监听抽象类
    @SubscribeEvent
    public static void addItemToPlay(PlayerTickEvent.Post event) {
        Player player=event.getEntity();
        UUID uuid=player.getUUID();
        //仅服务端
        if(!player.level().isClientSide){
            Level level=player.level();
            //获取玩家下方方块位置
            BlockPos pos=player.blockPosition().below();
            Block targedBlock=level.getBlockState(pos).getBlock();
            //获取玩家累计时间
            int nowTime=playerTimer.getOrDefault(uuid,0);
            nowTime++;
            playerTimer.put( uuid,nowTime);
            if(targedBlock== ModBlocks.NAILONG.get()&&nowTime>=timeNeeded){
                //放入背包
                player.getInventory().add(ModItems.NAILONG_FRAGMENT.toStack());
                playerTimer.remove(uuid);
            }
        }
    }
}
