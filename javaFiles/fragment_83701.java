public class RandomCards {
    public static void main(String[] args) {
        new RandomCards();
    }

    public RandomCards() {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                try {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLayout(new BorderLayout());
                    frame.add(new RandomCardsPane());
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception exp) {
                    exp.printStackTrace();
                }

            }

        });

    }

    public class RandomCardsPane extends JPanel {

        // A list is a collection of Image objects...
        private List<Image> cardList;
        private Image card = null;

        public RandomCardsPane() throws IOException {

            // My cards are stored in the default execution location of the program
            // and are named "Card_1.png" through "Card_51.png"...
            // You image loading process will be different, replace it here..

            // ArrayList is a dynamic list (meaning it can grow and shrink
            // over the life time of the list) and is backed by an array
            // which shouldn't concern you, the only thing you really need to
            // know is that it has excellent random access...
            cardList = new ArrayList<Image>(51);
            for (int index = 0; index < 51; index++) {
                cardList.add(ImageIO.read(new File("Card_" + index + ".png")));
            }

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    card = cardList.get(Math.min((int)Math.round(Math.random() * cardList.size()), 51));
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (card != null) {
                int x = (getWidth() - card.getWidth(this)) / 2;
                int y = (getHeight() - card.getHeight(this)) / 2;
                g.drawImage(card, x, y, this);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(225, 315);
        }
    }
}