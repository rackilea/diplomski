try {
    background = ImageIO.read(new File("C:\\Users\\Shane Whitehead\\Dropbox\\Wallpapers\\5781217115_4182ee16da_o.jpg"));
    background = background.getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
} catch (IOException e) {
    e.printStackTrace();
}