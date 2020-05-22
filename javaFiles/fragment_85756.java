private void gameOver(Label score) {
    for (Body body : worldBodies) {
        world.destroyBody(body);
    }
    dispose();
    myGame.setScreen(new GameOver());
}