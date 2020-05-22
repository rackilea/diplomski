BufferedImage img = null;
try {
    img = ImageIO.read(new File("/org/me/musiconweb/resources/Music-icon.png"));
} catch (IOException e) {
    e.printStackTrace();
}
BufferedImage dimg = img.getScaledInstance(label.width, label.height,
            Image.SCALE_SMOOTH);

jLabel1.setIcon(new javax.swing.ImageIcon(dimg));