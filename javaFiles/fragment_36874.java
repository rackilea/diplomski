GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
GraphicsDevice[] gs = ge.getScreenDevices();


// Get size of each screen

for (int i=0; i<gs.length; i++) {
    DisplayMode dm = gs[i].getDisplayMode();
    int screenWidth = dm.getWidth();
    int screenHeight = dm.getHeight();
}