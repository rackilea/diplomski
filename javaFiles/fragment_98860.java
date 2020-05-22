JPanel panel = new JPanel(){
    BufferedImage background = loadImage();

    private BufferedImage loadImage(){
        URL imagePath = getClass().getResource("Immagini/Board.png");
        BufferedImage result = null;
        try {
            result = ImageIO.read(imagePath);
        } catch (IOException e) {
            System.err.println("Errore, immagine non trovata");
        }
        return result;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension size = getSize();
        g.drawImage(background, 0, 0,size.width, size.height,0, 0, background.getWidth(), background.getHeight(), null);
    }
};