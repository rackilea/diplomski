public class FourRandomCards extends JFrame {
    JButton jbtRefresh = new JButton("Refresh");
    final CardsPanel cardsPanel = new CardsPanel();

    public FourRandomCards() {
    add(cardsPanel, BorderLayout.CENTER);
    add(jbtRefresh, BorderLayout.SOUTH);

//=============================================================
        /** can't figure out what to put in event-handler **/
        jbtRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardsPanel.refresh();
            }
        });
//=============================================================
    }


    public static void main(String[] args) {
        JFrame frame = new FourRandomCards();
        frame.setTitle("Four Random Cards");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private class CardsPanel extends JPanel {
        public CardsPanel() {
            refresh();
        }

        public void refresh() {
            removeAll();
            for (int i = 0; i < 4; i++) {
                int card = (int)(Math.random() * 54 + 1);
                ImageIcon cardIcon = new ImageIcon
                ("image/card/" + card + ".png");
                JLabel jlblCard = new JLabel(cardIcon);

                add(jlblCard);
            }
            revalidate();
            repaint();
        }
    }
}