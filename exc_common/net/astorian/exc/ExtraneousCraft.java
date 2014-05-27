package net.astorian.exc;

import net.astorian.exc.core.handlers.ChatMessageHandler;
import net.astorian.exc.core.handlers.ExcEventHandler;
import net.astorian.exc.lib.Reference;
import net.astorian.exc.util.Version;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class ExtraneousCraft {
	
	@Instance
	public static ExtraneousCraft instance;
	
	public static ChatMessageHandler chat = new ChatMessageHandler();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		Version.checkServerVersion();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		MinecraftForge.EVENT_BUS.register(new ExcEventHandler());
		FMLCommonHandler.instance().bus().register(new ExcEventHandler());
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
	
	
}
