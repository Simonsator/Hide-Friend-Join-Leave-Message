package de.simonsator.partyandfriends.hfjlm;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.api.events.OnlineStatusChangedMessageEvent;
import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

/**
 * @author simonbrungs
 * @version 1.0.0 29.12.16
 */
public class HFJLMMain extends PAFExtension implements Listener {
	private final String PERMISSION = "partyandfriends.showmessage";

	@Override
	public void onEnable() {
		ProxyServer.getInstance().getPluginManager().registerListener(this, this);
	}

	@EventHandler
	public void onOnlineStatusChanged(OnlineStatusChangedMessageEvent pEvent) {
		if (!(pEvent.getPlayer() instanceof OnlinePAFPlayer)) {
			pEvent.setCancelled(true);
			return;
		}
		if (!pEvent.getPlayer().hasPermission(PERMISSION))
			pEvent.setCancelled(true);
	}

}
