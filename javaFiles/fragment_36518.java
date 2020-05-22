File f = new File("pic.png");
if (f.exists() && f.canRead()) {
    try {
        img = ImageIO.read(f);
    } catch (IOException e) {
        e.printStackTrace();
    }
} else { } // Error message.