public class TestBoardGame {

    public static void main(String[] args) {
        new TestBoardGame();
    }

    public TestBoardGame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weightx = 1;
                gbc.weighty = 1;
                frame.add(new BoardGamePane(), gbc);

                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.weightx = 1;
                gbc.fill= GridBagConstraints.HORIZONTAL;
                JLabel text = new JLabel("Area for text");
                text.setHorizontalAlignment(JLabel.CENTER);
                frame.add(text, gbc);

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class BoardGamePane extends JPanel {

        public BoardGamePane() {

            setBorder(new LineBorder(Color.RED));
            setBackground(Color.ORANGE);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 300);
        }

        @Override
        public Dimension getMinimumSize() {
            return getPreferredSize();
        }

        @Override
        public Dimension getMaximumSize() {
            return getPreferredSize();
        }

    }    
}