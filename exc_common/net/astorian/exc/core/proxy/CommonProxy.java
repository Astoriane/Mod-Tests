package net.astorian.exc.core.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import net.astorian.exc.core.handlers.event.WorldEventHandler;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy implements IProxy {

	public void registerTileEntities() {

	}

	public void registerTexturesAndRendering() {

	}

	public void registerEventHandlers() {

		WorldEventHandler worldEventHandler = new WorldEventHandler();

		FMLCommonHandler.instance().bus().register(worldEventHandler);
		MinecraftForge.EVENT_BUS.register(worldEventHandler);
	}

	public void registerKeybindings() {

	}

	public void registerSounds() {

	}

}
