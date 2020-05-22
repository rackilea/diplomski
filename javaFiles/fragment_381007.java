private void render() {
    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);          // Clear The Screen And The Depth Buffer

    loadIdentity();
    GL11.glRotatef(yspeed++,0.0f,1.0f,0.0f);
    drawRect(texture, 1f, 1f, 1f);

    GL11.glMatrixMode(GL11.GL_PROJECTION);
    GL11.glLoadIdentity();
    GL11.glOrtho(0, 640, 480, 0, -1000, 1000);
    GL11.glMatrixMode(GL11.GL_MODELVIEW);
    GL11.glLoadIdentity();

    font2.drawString(100, 100, "NICE LOOKING FONTS!", Color.green);

}

public void loadIdentity(){
    GL11.glMatrixMode(GL11.GL_PROJECTION); // Select The Projection Matrix
    GL11.glLoadIdentity(); // Reset The Projection Matrix

    // Calculate The Aspect Ratio Of The Window
    GLU.gluPerspective(
      45.0f,
      (float) Display.getDisplayMode().getWidth() / (float) Display.getDisplayMode().getHeight(),
      0.1f,
      100.0f);


    GL11.glMatrixMode(GL11.GL_MODELVIEW);
    GL11.glLoadIdentity();
    float camAngle = (float) Math.atan2(playerX, playerZ);
    float radius = 5;
    GLU.gluLookAt(playerX + (float)(Math.sin(camAngle) * radius), 0, playerZ + (float)(Math.cos(camAngle) * radius), 0, 0, 0, 0, 1, 0);
    //GL11.glGetMatrix();
}