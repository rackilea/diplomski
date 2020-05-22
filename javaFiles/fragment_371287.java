java.net.URL imgURL = getClass().getResource("/path/to/icon");
ImageIcon icon;
if (imgURL != null) {
    icon = new ImageIcon(imgURL, description);
} else {
    System.err.println("Couldn't find icon path");
}