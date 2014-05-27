package net.astorian.exc.core.proxy;

import net.astorian.exc.core.handlers.event.PlayerEventHandler;
import net.astorian.exc.core.handlers.event.WorldEventHandler;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;

public class CommonProxy implements IProxy {

	public void registerTileEntities() {

	}

	public void registerTexturesAndRendering() {

	}

	public void registerEventHandlers() {

		PlayerEventHandler playerEventHandler = new PlayerEventHandler();
		WorldEventHandler worldEventHandler = new WorldEventHandler();

		FMLCommonHandler.instance().bus().register(worldEventHandler);
		MinecraftForge.EVENT_BUS.register(worldEventHandler);
		
		FMLCommonHandler.instance().bus().register(playerEventHandler);
		MinecraftForge.EVENT_BUS.register(playerEventHandler);
	}

	public void registerKeybindings() {

	}

	public void registerSounds() {

	}

}
