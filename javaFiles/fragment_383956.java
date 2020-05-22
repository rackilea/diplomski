Image img = null;
Image img2 = null;

try {
    img = ImageIO.read(new File(Main.imagePath + "1.jpg"));
    img2 = ImageIO.read(new File(Main.imagePath + "2.jpg"));
} catch (IOException e) {
    e.printStackTrace();
}

Image simg = img.getScaledInstance(310, 90, Image.SCALE_SMOOTH);
Image simg2 = img2.getScaledInstance(310, 90, Image.SCALE_SMOOTH);

JLabel simgLabel = new JLabel(new ImageIcon(simg));
JLabel simgLabel2 = new JLabel(new ImageIcon(simg2));

Main.ScreenText.setLayout(new BoxLayout(Main.ScreenText, BoxLayout.Y_AXIS));
Main.ScreenText.insertComponent( simgLabel );
Main.ScreenText.insertComponent( simgLabel2 );