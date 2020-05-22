private void prepare() {

    if(DisplayManager.isResized()) {
        DisplayManager.updateViewPort();
        createProjectionMatrix();
    }
    Camera.calcViewMatrix();

    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
    GL11.glClearColor(1, 0, 0, 1);
}