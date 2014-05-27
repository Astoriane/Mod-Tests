package net.astorian.exc.core.handlers.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerEventHandler {
	
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		if(event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;

			//TODO DO STUFF HERE
			
		}
			
	}

}
