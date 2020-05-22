public class TicTac extends JFrame {

    static JButton[][] boxes = new JButton[4][4];
    static int[][] check = new int[4][4];
    static JTextField blank1 = new JTextField();
    static JTextField blank2 = new JTextField();
    static int turns = 1;

    static ImageIcon back = new ImageIcon("cardback.jpg");
    static ImageIcon x = new ImageIcon("x.jpg");
    static ImageIcon o = new ImageIcon("o.jpg");

    public TicTac() {

        JPanel gamePanel = new JPanel(new GridLayout(5, 4, 10, 10));

        for (int x = 0; x<=3; x++) {
            for (int y = 0; y<=3; y++) {
                boxes[x][y] = new JButton(""+x+y, back);
                boxes[x][y].addActionListener(new XOActionListenr(x, y));
                gamePanel.add(boxes[x][y]);
            }
        }

        JButton play = new JButton("Play");
        JButton restart = new JButton("Restart");
        play.addActionListener(new PlayActionListenr());
        restart.addActionListener(new RestartActionListenr());

        setLayout(new FlowLayout());
        gamePanel.add(blank1);
        gamePanel.add(play);
        gamePanel.add(blank2);
        gamePanel.add(restart);
        add(gamePanel);

        setTitle("Tic Tac Toe");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void winner() {

        // Check for winner
    }

    private class XOActionListenr implements ActionListener {

        private int row, col;

        private XOActionListenr(int row, int col) {

            this.row = row;
            this.col = col;
        }

        public void actionPerformed(ActionEvent e) {

            if (turns % 2 == 0) {
                boxes[row][col].setText("O");
                boxes[row][col].setIcon(o);
                check[row][col] = 2;
            }
            else {
                boxes[row][col].setText("X");
                boxes[row][col].setIcon(x);
                check[row][col] = 1;
            }
            winner();
            turns++;
        }
    }

    private class PlayActionListenr implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // Not sure why you would need the "play" button at all,
            // but insert here what it's supposed to do
        }
    }

    private class RestartActionListenr implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            for (int x = 0; x<=3; x++) {
                for (int y = 0; y<=3; y++) {
                    boxes[x][y].setText(""+x+y);
                    boxes[x][y].setIcon(back);
                }
            }
        }
    }

    public static void main(String[] arguments) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                new TicTac();
            }
        });
    }
}