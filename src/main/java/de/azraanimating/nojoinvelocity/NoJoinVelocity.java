package de.azraanimating.nojoinvelocity;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import de.azraanimating.nojoinvelocity.config.Config;
import de.azraanimating.nojoinvelocity.listener.ServerPreConnectListener;

import javax.inject.Inject;
import java.io.File;
import java.util.logging.Logger;

@Plugin(id = "nojoin-1", name = "NoJoin Plugin", version = "1.0-SNAPSHOT")
public class NoJoinVelocity {
    private final ProxyServer server;
    private final Logger logger;

    @Inject
    public NoJoinVelocity(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
    }

    @Subscribe
    public void onInitialize(ProxyInitializeEvent event) {
        try {
            Config config = Config.fromFile(new File("plugins/NoJoinVelocity/config.json"));
            this.server.getEventManager().register(this, new ServerPreConnectListener(config.message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
