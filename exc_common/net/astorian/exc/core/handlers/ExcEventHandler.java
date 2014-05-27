package net.astorian.exc.core.handlers;

import net.astorian.exc.ExtraneousCraft;
import net.astorian.exc.lib.Strings;
import net.astorian.exc.util.Version;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class ExcEventHandler {
	
	@SubscribeEvent
	public void onWorldEnter(PlayerLoggedInEvent event) {
		ExtraneousCraft.chat.sendChatMessageToPlayer(event.player, String.valueOf(Version.getLocalVersionNumber()));
		ExtraneousCraft.chat.sendChatMessageToPlayer(event.player, String.valueOf(Version.getServerVersionNumber()));
		ExtraneousCraft.chat.sendChatMessageToPlayer(event.player, String.valueOf(Version.hardcoreOutdatedCheck()));
	}
	
	@SubscribeEvent
	public void onItemToss(ItemTossEvent event) {
		
	}

}
