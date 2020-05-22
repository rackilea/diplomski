try {
    Display.setParent(canvas);

    frame.setPreferredSize(new Dimension(1024, 786));
    frame.setMinimumSize(new Dimension(800, 600));
    frame.pack();
    frame.setVisible(true);

    Display.create();

    while(!Display.isCloseRequested() && !closeRequested)
    {
        // main code or call to code goes here

        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        Display.update();
    }

    Display.destroy();
    frame.dispose();
    System.exit(0);

} catch (LWJGLException e) {
    e.printStackTrace();
}