package de.cubenation.cnmobspawnflags.flags;

import com.sk89q.worldguard.protection.flags.StateFlag;

public class SpawnFlags {

    public final static StateFlag BREEDING = new StateFlag("breeding", true);
    public final static StateFlag MOB_SPAWN_FROM_BUILD = new StateFlag("mob-spawn-from-build", true);
    public final static StateFlag MOB_SPAWN_FROM_SPAWNER = new StateFlag("mob-spawn-from-spawner", true);
    public final static StateFlag MOB_SPAWN_FROM_SPAWN_EGG = new StateFlag("mob-spawn-from-spawn-egg", true);
    public final static StateFlag MOB_SPAWN_FROM_POTION = new StateFlag("mob-spawn-from-potion", true);
    public final static StateFlag MOB_SPAWN_NATURAL = new StateFlag("mob-spawn-natural", true);

}
