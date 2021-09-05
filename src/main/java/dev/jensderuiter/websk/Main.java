package dev.jensderuiter.websk;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import dev.jensderuiter.websk.web.Webserver;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Main extends JavaPlugin {

    Main instance;
    SkriptAddon addon;
    public static Webserver webserver = null;

    @Override
    public void onEnable() {
        instance = this;
        addon = Skript.registerAddon(this);
        try {
            addon.loadClasses("dev.jensderuiter.websk", "skript");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        if (webserver != null) {
            webserver.shutdown();
        }
    }

    public Main getInstance() {
        return instance;
    }

    public SkriptAddon getAddonInstance() {
        return addon;
    }
}