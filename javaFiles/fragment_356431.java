try {
    BufferedImage bufImg=ImageIO.read(new File("d:\\img.png"));
    jlabel.setIcon(new ImageIcon(bufImg));
    //jlabel.repaint();
    //works even without repaint
}
catch (IOException ex) {
    System.out.println("Unable to read image file");
}