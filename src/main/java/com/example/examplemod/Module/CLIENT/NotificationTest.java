package com.example.examplemod.Module.CLIENT;

import com.example.examplemod.Module.Module;
import font.FontUtils;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

import java.awt.*;

import static com.example.examplemod.UI.ui.rainbow;
import static net.minecraft.client.gui.Gui.drawRect;

public class NotificationTest extends Module {

    public NotificationTest() {
        super("Notification", Keyboard.KEY_NONE, Category.CLIENT);
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post e) throws InterruptedException{
        drawRect(431, 375, 670, 318, new Color(0x151515).hashCode());
        drawRect(431, 375, 436, 318, rainbow(300));//431, 375, 670, 318

        FontUtils.normal.drawString("§lNotifications §l§4T§ce§6s§et§2C§al§be§3n§1t", 500, 325, -1);
        FontUtils.normal.drawString("§l§aEnable §fNotifications", 440, 340, -1);
    }
}