public class Window extends JFrame {

    JPanel p = new JPanel();
    JLabel lbl = new JLabel("Enter the number if you have seen it before, Else empty.");
    JLabel res = new JLabel("....");
    static JTextField ans = new JTextField(10);
    Board board = new Board();

    public Window() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(board, BorderLayout.CENTER);
        p.setLayout(new BorderLayout(8, 8));
        p.add(lbl, BorderLayout.WEST);
        ans.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (ans.getText().equals(Board.num)) {
                    res.setText("Good");
                } else {
                    res.setText("Bad");
                }
                ans.setText("");
                board.repaint();
            }

        });
        p.add(ans, BorderLayout.CENTER);
        p.add(res, BorderLayout.EAST);
        p.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(p, BorderLayout.SOUTH);
        setResizable(false);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Window();
            }
        });
    }

}