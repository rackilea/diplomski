public static void drawMyStuff(JPanel panel, Color color, int startPoint, int endPoint) {
    // Declare and initialize a graphics object 
    // based on the supplied JPanel.
    Graphics g = panel.getGraphics();

    // Set the color we want to use...
    g.setColor(color);  // here we supply our color parameter

    // Draw a red line horizontally through the 
    // center of the supplied JPanel. Notice our 
    // new startPoint and endPoint parameters are
    // supplied here.
    g.drawLine(startPoint, panel.getHeight()/2, endPoint, panel.getHeight()/2);

    // Close the Graphics object, we don't need it anymore.
    g.dispose();

    // Update the supplied JPanel so as
    // to display what we've drawn.
    panel.revalidate(); 
}