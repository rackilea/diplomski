if (isTablet(glGame)) {
    world.update(deltaTime, game.getInput().getAccelX());
}
if (!isTablet(glGame)) {
    world.update(deltaTime, game.getInput().getAccelY());
}