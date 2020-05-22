public static void drawMyStuff(JPanel panel) {
    // Declare and initialize a graphics object 
    // based on the supplied component.
    Graphics g = panel.getGraphics();

    // Set the color we want to use...
    g.setColor(Color.red);

    // Draw a red line horizontally through the 
    // center of the supplied component.
    g.drawLine(0, panel.getHeight()/2, panel.getWidth(), panel.getHeight()/2);

    // Close the Graphics object, we don't need it anymore.
    g.dispose();

    // Update the supplied component so as
    // to display what we've drawn.
    panel.revalidate(); 
}