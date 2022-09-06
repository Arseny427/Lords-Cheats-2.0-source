package com.example.examplemod.Module.COMBAT;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.Module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import yea.bushroot.clickgui.Setting;

public class AutoShieldDestroy extends Module {
    public static boolean destroy;

    public AutoShieldDestroy() {
        super("AutoShieldDestroy", Keyboard.KEY_NONE, Category.MOVEMENT);

        ExampleMod.instance.settingsManager.rSetting(new Setting("Delay", this, 600, 0, 900, true));
        ExampleMod.instance.settingsManager.rSetting(new Setting("SwapBack", this, true));
    }
    @SubscribeEvent
    public void onUpdate(TickEvent.PlayerTickEvent e) {
        double delay = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Delay").getValDouble();
        boolean swapback = ExampleMod.instance.settingsManager.getSettingByName(this.name, "SwapBack").getValBoolean();

    }
}