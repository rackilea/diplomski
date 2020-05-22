//Need to have a JDesktopPane to add the JInternalFrame to
JDesktopPane desktop;

//Adding the internal frame to the JDesktopPane
MyInternalFrame frame = new MyInternalFrame();
frame.setVisible(true);
desktop.add(frame);
try {
   frame.setSelected(true);
} catch (java.beans.PropertyVetoException e) {
    //Do error stuff - optional
}