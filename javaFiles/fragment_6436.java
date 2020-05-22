public void drawScene(GL10 gl)
{
    // Clear scene
    gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
    // Move left top corner of camera to specified point
    gl.glTranslatef(-camera.getX(), screenManager.getScreenHeight() - camera.getY(), 0f);
    // Render all objects from the scene
    root.renderObjects(gl);
    // Fixed position for HUD elements
    gl.glLoadIdentity();
    // Render hud to the screen
    hud.renderObjects(gl);
    gl.glLoadIdentity();
}