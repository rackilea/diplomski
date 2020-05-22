GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
GraphicsDevice[] devices = g.getScreenDevices();

for (int i = 0; i < devices.length; i++) {
    System.out.println("Width:" + devices[i].getDisplayMode().getWidth());
    System.out.println("Height:" + devices[i].getDisplayMode().getHeight());
}