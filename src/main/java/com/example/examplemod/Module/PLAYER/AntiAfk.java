package com.example.examplemod.Module.PLAYER;

import com.example.examplemod.Module.Module;
import net.minecraftforge.client.model.MapModelState;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class AntiAfk extends Module {

    public AntiAfk() {
        super("AntiAfk", Keyboard.KEY_NONE, Category.PLAYER);
    }
    @SubscribeEvent

    public void onPlayerTickEvent(TickEvent.PlayerTickEvent e) {

        if (mc.player.onGround) {

            mc.player.jump();


        }

    }
}