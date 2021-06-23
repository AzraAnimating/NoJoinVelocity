package de.azraanimating.nojoinvelocity.listener;

import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.ServerPreConnectEvent;
import net.kyori.adventure.text.Component;

public class ServerPreConnectListener {

    private final String message;

    public ServerPreConnectListener(String message) {
        this.message = message;
    }

    @Subscribe(order = PostOrder.EARLY)
    public void onServerPreConnect(ServerPreConnectEvent event) {
        event.getPlayer().disconnect(Component.text(message));
    }

}
