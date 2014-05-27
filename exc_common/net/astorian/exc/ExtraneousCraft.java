package net.astorian.exc;

import java.io.File;

import net.astorian.exc.core.config.ConfigurationHandler;
import net.astorian.exc.core.config.ConfigurationSettings;
import net.astorian.exc.core.handlers.ChatMessageHandler;
import net.astorian.exc.core.helpers.StartupHelper;
import net.astorian.exc.core.proxy.IProxy;
import net.astorian.exc.lib.Reference;
import net.astorian.exc.util.ExcLogger;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class ExtraneousCraft {

	@Instance(Reference.MOD_ID)
	public static ExtraneousCraft instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;

	public static ChatMessageHandler chat = new ChatMessageHandler();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigurationHandler.init(event.getModConfigurationDirectory()
				.getAbsolutePath()
				+ File.separator
				+ Reference.MOD_ID.toUpperCase() + File.separator);

		proxy.registerKeybindings();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		proxy.registerTileEntities();

		proxy.registerTexturesAndRendering();

		proxy.registerSounds();

		proxy.registerEventHandlers();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		if (ConfigurationSettings.enableVersionCheck) {
			StartupHelper.checkVersion();
			StartupHelper.logVersion();
		} else
			ExcLogger
					.warn("Auto version check disabled. However it is recommended for you to enable this feature.");
	}

}
