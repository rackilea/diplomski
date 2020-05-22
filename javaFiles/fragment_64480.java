@Override
public void render(float delta) {

    delta*=speed;  //<---

    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    camera.update();
    world.setDelta(delta);
    world.process();
    spriteRenderSystem.process();
}