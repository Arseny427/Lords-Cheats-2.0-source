package com.example.examplemod;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;


public class DiscordRP {

    private boolean running = true;
    private long created = 0;

    public void start() {
        this.created = System.currentTimeMillis();

        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {
            @Override
            public void apply(DiscordUser user) {
                System.out.println("Welcome " + user.username + "On Lords Cheats");
                update("Boosting up...", "");

            }
        }).build();

        DiscordRPC.discordInitialize("970263688005181470", handlers, true);

        new Thread("Discord RPC Callback") {
            @Override
            public void run() {

                while (running) {
                    DiscordRPC.discordRunCallbacks();
                }

            }
        }.start();

    }


    public void shutdown() {
        running = false;
        DiscordRPC.discordShutdown();
    }




    public void update(String firstLine, String secondLine) {
        DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
        b.setBigImage("lords_cheats_icon", "Lords Cheats icon");
        b.setDetails(firstLine);
        b.setStartTimestamps(created);

        DiscordRPC.discordUpdatePresence(b.build());
    }
}
