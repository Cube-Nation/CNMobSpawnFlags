package de.cubenation.cnmobspawnflags;

import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import de.cubenation.cnmobspawnflags.flags.SpawnFlags;
import de.cubenation.cnmobspawnflags.listeners.CreatureSpawnListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CNMobSpawnFlagsPlugin extends JavaPlugin {

    private WorldGuard worldGuard;

    @Override
    public void onLoad() {
        worldGuard = WorldGuard.getInstance();

        worldGuard.getFlagRegistry().register(SpawnFlags.BREEDING);
        worldGuard.getFlagRegistry().register(SpawnFlags.MOB_SPAWN_FROM_BUILD);
        worldGuard.getFlagRegistry().register(SpawnFlags.MOB_SPAWN_FROM_SPAWNER);
        worldGuard.getFlagRegistry().register(SpawnFlags.MOB_SPAWN_FROM_SPAWN_EGG);
        worldGuard.getFlagRegistry().register(SpawnFlags.MOB_SPAWN_FROM_POTION);
        worldGuard.getFlagRegistry().register(SpawnFlags.MOB_SPAWN_NATURAL);
    }

    @Override
    public void onEnable() {
        RegionContainer regionContainer = worldGuard.getPlatform().getRegionContainer();
        getServer().getPluginManager().registerEvents(new CreatureSpawnListener(regionContainer), this);
    }
}
