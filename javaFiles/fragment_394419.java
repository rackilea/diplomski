BufferedImage img;
try {
    img = ImageIO.read(new File("strawberry.jpg"));
} catch (IOException e) {
    e.printStackTrace();
}

BufferedImage dimg = img.getScaledInstance(64, 64,        Image.SCALE_SMOOTH);

ImageIcon imageIcon = new ImageIcon(dimg);