public void actionPerformed(ActionEvent e) {
    String red = theApplet.textR.getText();
    String green = theApplet.textG.getText();
    String blue = theApplet.textB.getText();
    theApplet.textR.setText("");
    theApplet.textG.setText("");
    theApplet.textB.setText("");

    try {
        int r = Integer.parseInt(red.trim());
        int g = Integer.parseInt(green.trim());
        int b = Integer.parseInt(blue.trim());
        if (e.getSource() == theApplet.butChange)
            theApplet.str = "Goodbye";
        theApplet.col = new Color(r, g, b);
        if (e.getSource() == theApplet.butReset)
            theApplet.str = "Hello";
        theApplet.repaint();
    } catch (NumberFormatException ex) {
        ex.printStackTrace();
    }
}