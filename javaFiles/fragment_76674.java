public class CardImagePanel extends JPanel {

    BufferedImage cardImage;

    public CardImagePanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        try {
            cardImage = ImageIO.read(new File("c:\\dev\\cards\\2_of_clubs.png"));
        } catch (IOException ex) {
            System.out.println("Exception trying to load image file.");
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return cardImage != null ? new Dimension(cardImage.getWidth(), cardImage.getHeight()) : super.getPreferredSize();
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(cardImage, 0, 0, this);
    }
}