public static MountainCreature createCreature(MountainCreature.Creature type) {
    MountainCreature creature;
    switch(type) {
        case GOBLINS:
            creature = new MountainCreature( /* goblin-specific characteristics here */);
        break;
        case DWARVES:
            creature = new MountainCreature( /* dwarf-specific characteristics here */);
        break;
        // And so on...
    }
    return creature;
}