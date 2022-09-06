package com.example.examplemod.Module.COMBAT;

import com.example.examplemod.Module.Module;
import com.example.examplemod.Utils.ChatUtils;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class AntiBot extends Module {
    public AntiBot() {
        super("AntiBot", Keyboard.KEY_NONE, Category.COMBAT);

    }

    @SubscribeEvent
    public void onUpdate(RenderWorldLastEvent e) {
        try {
            for (EntityPlayer entityPlayer : mc.world.playerEntities) {
                //int ping = mc.getConnection().getPlayerInfo(entityPlayer.getUniqueID()).getResponseTime();

                if (entityPlayer.isInvisible() && entityPlayer != mc.player) {
                    mc.world.removeEntity(entityPlayer);
                    mc.player.playSound(SoundEvents.BLOCK_ANVIL_LAND, 0.5f, 1.f);
                    mc.world.spawnEntity(new EntityLightningBolt(mc.world, entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ, true));
                }
                if (entityPlayer.noClip && entityPlayer.getDistance(mc.player) <= 7 && entityPlayer != mc.player) {
                    mc.world.removeEntity(entityPlayer);
                    mc.player.playSound(SoundEvents.BLOCK_ANVIL_LAND, 0.5f, 1.f);
                    mc.world.spawnEntity(new EntityLightningBolt(mc.world, entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ, true));

                }if(mc.getConnection().getPlayerInfo(entityPlayer.getName()) == null && entityPlayer != mc.player){
                    mc.world.removeEntity(entityPlayer);
                    mc.player.playSound(SoundEvents.BLOCK_ANVIL_LAND, 0.5f, 1.f);
                    mc.world.spawnEntity(new EntityLightningBolt(mc.world, entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ, true));
                }
            }
        } catch (Exception ex) {
            ChatUtils.sendMessage("AntiBot Error");
        }
    }
}