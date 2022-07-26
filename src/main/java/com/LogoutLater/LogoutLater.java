package com.LogoutLater;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.events.GameTick;

import java.awt.*;

import static java.awt.event.KeyEvent.VK_A;
import static org.lwjgl.system.windows.User32.VK_BACK;

@Slf4j
@PluginDescriptor(
	name = "LogoutLater"
)
public class LogoutLater extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private int counter;


	public LogoutLater() throws AWTException {
	}

	private void onGameTick(GameTick gameTick) throws AWTException {
		Robot Robit = new Robot();
		if(counter <= 3) {
			if (client.getKeyboardIdleTicks() > 14900) {
				Robit.keyPress(VK_A);
				Robit.keyRelease(VK_A);
				Robit.keyPress(VK_BACK);
				Robit.keyRelease(VK_BACK);
				counter++;
			}
			if (client.getMouseIdleTicks() > 14900) {
				Robit.keyPress(VK_A);
				Robit.keyRelease(VK_A);
				Robit.keyPress(VK_BACK);
				Robit.keyRelease(VK_BACK);
				counter++;
			}
		}
	}
	
}

