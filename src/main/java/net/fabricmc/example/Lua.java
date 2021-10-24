package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;

import com.mojang.brigadier.arguments.ArgumentType;
import static com.mojang.brigadier.arguments.IntegerArgumentType.*;
import static com.mojang.brigadier.builder.LiteralArgumentBuilder.*;
import static com.mojang.brigadier.arguments.StringArgumentType.*;
import static com.mojang.brigadier.builder.RequiredArgumentBuilder.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lua implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("modid");

	public static final String mystr = "hola";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
			dispatcher.register(CommandManager.literal("lua")
				.then(CommandManager.argument("luaString",string())
					.executes(context->{
						System.out.println(getString(context, "luaString"));
						return 1;
					})
				)
			);
			dispatcher.register(CommandManager.literal("@")
				.then(CommandManager.argument("luaString",string())
					.executes(context->{
						System.out.println(getString(context, "luaString"));
						return 1;
					})
				)
			);
            //if (dedicated) {
             //   TestDedicatedCommand.register(dispatcher);
            //}
        });
		LOGGER.info("Hello Fabric world!");
	}
}
