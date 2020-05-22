for (int i = 0; i < buttons.length; i++) { //Goes one time through the complete Array
    for (int j = 0; j < buttons[i].length; j++) {
        if(buttons[i][j].getBackground() != Color.black) {
            BufferedImage img = ImageIO.read(new File("kronk/"+(i*5 + j + 1)+".png"));
            buttons[i][j].setText("");
            buttons[i][j].setIcon(new ImageIcon(img));
        }
    }
}