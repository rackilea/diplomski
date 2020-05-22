World world;
if (RubeWorldSerializer.mergeWorld == null) {
    world = new World(gravity, allowSleep);
    world.setAutoClearForces(autoClearForces);
    world.setContinuousPhysics(continuousPhysics);
    world.setWarmStarting(warmStarting);
} else {
    world = RubeWorldSerializer.mergeWorld;
}