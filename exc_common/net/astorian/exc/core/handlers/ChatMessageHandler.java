package net.astorian.exc.core.handlers;

import net.astorian.exc.lib.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class ChatMessageHandler {

	private static ChatStyle style = new ChatStyle();

	private static IChatComponent createChatComponent() {
		ChatComponentText component = new ChatComponentText("["
				+ Reference.MOD_NAME + "] ");
		component.setChatStyle(style);
		style.setColor(EnumChatFormatting.DARK_GRAY);
		return component;
	}

	private static IChatComponent createChatMessage(String text) {
		return createChatComponent().appendText(text);
	}

	public void sendChatMessageToPlayer(EntityPlayer player, String text) {
		player.addChatMessage(createChatMessage(text));
	}

}