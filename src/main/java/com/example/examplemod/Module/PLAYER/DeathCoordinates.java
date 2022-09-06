
package com.example.examplemod.Module.PLAYER;

import com.example.examplemod.Module.Module;
import com.example.examplemod.Utils.ChatUtils;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class DeathCoordinates extends Module {
    private ChatUtils ChatUtil;

    public DeathCoordinates() {
        super("DeathCoordinates", Keyboard.KEY_NONE, Category.PLAYER);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (mc.player.getHealth() < 1 && mc.currentScreen instanceof GuiGameOver) {
            if (mc.player.ticksExisted % 20 == 0) {
                ChatUtil.sendMessage(TextFormatting.WHITE + "DeathCoordinates" + TextFormatting.GRAY + ": " + "X: " + mc.player.getPosition().getX() + " Y: " + mc.player.getPosition().getY() + " Z: " + mc.player.getPosition().getZ() + ".");
            }
        }
    }
}