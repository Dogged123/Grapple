package dogged.grapple;

import dogged.grapple.commands.GrappleCommand;
import dogged.grapple.listeners.GrappleListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Grapple extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("grapple").setExecutor(new GrappleCommand());

        getServer().getPluginManager().registerEvents(new GrappleListener(), this);
    }
}
