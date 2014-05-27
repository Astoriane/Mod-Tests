package net.astorian.exc.core.handlers;

import net.astorian.exc.ExtraneousCraft;
import net.astorian.exc.lib.Reference;
import net.astorian.exc.lib.Strings;
import net.astorian.exc.util.Version;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class ExcEventHandler {

	@SubscribeEvent
	public void onWorldEnter(PlayerLoggedInEvent event) {
		ExtraneousCraft.chat.sendChatMessageToPlayer(event.player,
				Strings.VERSION_CHECK_NEUTRAL + Reference.MOD_VERSION);
		if (Version.isOutdated()) {
			ExtraneousCraft.chat
					.sendChatMessageToPlayer(
							event.player,
							Strings.VERSION_CHECK_OUTDATED
									+ Version.getServerVersion());
		}
	}

	@SubscribeEvent
	public void onItemToss(ItemTossEvent event) {

	}

}
