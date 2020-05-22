GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
GraphicsDevice[] screens = ge.getScreenDevices();

for (GraphicsDevice screen : screens) {
 Robot robotForScreen = new Robot(screen);
 ...