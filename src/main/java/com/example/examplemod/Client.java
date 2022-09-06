package com.example.examplemod;

import com.example.examplemod.Module.CLIENT.ClickGUI;
import com.example.examplemod.Module.CLIENT.NotificationTest;
import com.example.examplemod.Module.CLIENT.Panic;
import com.example.examplemod.Module.COMBAT.*;
import com.example.examplemod.Module.EXPLOIT.HackerDetector;
import com.example.examplemod.Module.MISC.AutoRespawn;
import com.example.examplemod.Module.MISC.ChestStealer;
import com.example.examplemod.Module.MISC.MiddleClickPearl;
import com.example.examplemod.Module.MOVEMENT.*;
import com.example.examplemod.Module.Module;
import com.example.examplemod.Module.PLAYER.AntiAfk;
import com.example.examplemod.Module.PLAYER.AntiFire;
import com.example.examplemod.Module.PLAYER.BlockReach;
import com.example.examplemod.Module.EXPLOIT.FakeCreative;
import com.example.examplemod.Module.PLAYER.DeathCoordinates;
import com.example.examplemod.Module.RENDER.*;
import font.FontUtils;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;
import yea.bushroot.clickgui.ClickGuiManager;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Client {
    public static String name = "Lords Cheats 2.0 | User: " + Minecraft.getMinecraft().getSession().getUsername();
    public static String cName = "Lords Cheats §fB§a2.0";
    public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();

    public static ClickGuiManager clickGuiManager;


    private static final Client INSTANCE = new Client();
    public static final Client getInstance() {
        return INSTANCE;
    }

    private DiscordRP discordRP = new DiscordRP();


    public void init() {
        discordRP.start();
    }

    public static void startup() {
        Display.setTitle(name);

        modules.add(new ClickGUI());
        modules.add(new HackerDetector());
        modules.add(new BHOP());
        modules.add(new InvWalk());
        modules.add(new FakePlayer());
        modules.add(new Velocity());
        modules.add(new FastFall());
        modules.add(new ItemsESP());
        modules.add(new NameTags());
        modules.add(new FakeCreative());
        modules.add(new BlockReach());
        modules.add(new TriggerBot());
        modules.add(new WaterLeave());
        modules.add(new AttackTrace());
        modules.add(new FullBright());
        modules.add(new ViewModel());
        modules.add(new KillAura());
        modules.add(new HightJump());
        modules.add(new TargetHUD());
        modules.add(new ChestESP());
        modules.add(new GlowESP());
        modules.add(new Tracers());
        modules.add(new AirJump());
        modules.add(new BoatFly());
        modules.add(new AntiBot());
        modules.add(new BoxESP());
        modules.add(new Sprint());
        modules.add(new HitBox());
        modules.add(new Spider());
        modules.add(new Jesus());
        modules.add(new Glide());
        modules.add(new Fly());
        modules.add(new AimBot());
        modules.add(new Particles());
        modules.add(new PlayerEntity());
        modules.add(new SpawnerESP());
        modules.add(new Speed());
        modules.add(new Panic());
        modules.add(new ChinaHat());
        modules.add(new Trails());
        modules.add(new AutoTotem());
        modules.add(new AntiFire());
        modules.add(new NotificationTest());
        modules.add(new AntiAfk());
        modules.add(new DeathCoordinates());
        modules.add(new AutoRespawn());
        modules.add(new AutoGapple());
        modules.add(new Criticals());
        modules.add(new SkyColor());
        modules.add(new AttackEffect());
        modules.add(new JumpCircle());
        modules.add(new Trajectories());
        modules.add(new FastBow());
        modules.add(new MiddleClickPearl());
        modules.add(new BlockObject());
        modules.add(new ChestStealer());



        clickGuiManager = new ClickGuiManager();

        FontUtils.bootstrap();
    }

    public static ArrayList<Module> getModulesInCategory(Module.Category c) {
        ArrayList<Module> mods = new ArrayList<Module>();
        for (Module m : modules) {
            if (m.getCategory().name().equalsIgnoreCase(c.name())) {
                mods.add(m);
            }
        }
        return mods;
    }

    public static void keyPress(int key) {
        for (Module m : modules) {
            if (m.getKey() == key) {
                m.toggle();
            }
        }
    }



    public void shutdown() {
        discordRP.shutdown();

    }

    public DiscordRP getDiscordRP() {
        return discordRP;
    }

}
