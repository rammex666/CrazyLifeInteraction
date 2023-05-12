package org.rammex.crazylifeinteraction;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.rammex.crazylifeinteraction.event.piedbiche;

public final class CrazyLifeInteraction extends JavaPlugin {



    @Override
    public void onEnable() {
        new piedbiche();
        getLogger().info("----------------------------");
        getLogger().info("plugin crée par Rammex#3465 3.0");
        getLogger().info("----------------------------");
        Bukkit.getPluginManager().registerEvents(new piedbiche(),this);

    }

    @Override
    public void onDisable() {
        getLogger().info("----------------------------");
        getLogger().info("plugin crée par Rammex#3465");
        getLogger().info("----------------------------");
    }
}
