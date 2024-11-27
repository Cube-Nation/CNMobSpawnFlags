package de.cubenation.cnmobspawnflags.listeners;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.util.Location;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import de.cubenation.cnmobspawnflags.flags.SpawnFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.jetbrains.annotations.NotNull;

public class CreatureSpawnListener implements Listener {

    private final RegionContainer regionContainer;

    public CreatureSpawnListener(final @NotNull RegionContainer regionContainer) {
        this.regionContainer = regionContainer;
    }

    @EventHandler
    public void onCreatureSpawn(final @NotNull CreatureSpawnEvent event) {
        switch (event.getSpawnReason()) {
            case BREEDING -> handleSpawnFlag(event, SpawnFlags.BREEDING);
            case BUILD_IRONGOLEM, BUILD_WITHER, BUILD_SNOWMAN -> handleSpawnFlag(event, SpawnFlags.MOB_SPAWN_FROM_BUILD);
            case SPAWNER, TRIAL_SPAWNER -> handleSpawnFlag(event, SpawnFlags.MOB_SPAWN_FROM_SPAWNER);
            case SPAWNER_EGG, DISPENSE_EGG -> handleSpawnFlag(event, SpawnFlags.MOB_SPAWN_FROM_SPAWN_EGG);
            case POTION_EFFECT -> handleSpawnFlag(event, SpawnFlags.MOB_SPAWN_FROM_POTION);
            case NATURAL, SILVERFISH_BLOCK, SPELL, TRAP, VILLAGE_DEFENSE, VILLAGE_INVASION, PATROL, ENDER_PEARL, EGG, REINFORCEMENTS, RAID -> handleSpawnFlag(event, SpawnFlags.MOB_SPAWN_NATURAL);
        }
    }

    private void handleSpawnFlag(final @NotNull CreatureSpawnEvent event, final @NotNull StateFlag flag) {
        Location location = BukkitAdapter.adapt(event.getLocation());
        StateFlag.State state = this.regionContainer.createQuery().getApplicableRegions(location).queryState(null, flag);
        if (state == StateFlag.State.DENY) {
            event.setCancelled(true);
        }
    }
}
