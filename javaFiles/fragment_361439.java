private float accumulator = 0;

private void doPhysicsStep(float deltaTime) {
    // fixed time step
    // max frame time to avoid spiral of death (on slow devices)
    float frameTime = Math.min(deltaTime, 0.25f);
    accumulator += frameTime;
    while (accumulator >= Constants.TIME_STEP) {
        WorldManager.world.step(Constants.TIME_STEP, Constants.VELOCITY_ITERATIONS, Constants.POSITION_ITERATIONS);
        accumulator -= Constants.TIME_STEP;
    }
}