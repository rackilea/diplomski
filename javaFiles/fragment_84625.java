public class SwingUnitTesting extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingUnitTesting::new);
    }

    JTextField tf = new JTextField();
    JButton btn = new JButton("Test Button");

    SwingUnitTesting() {
        add(tf, BorderLayout.PAGE_END);
        add(btn, BorderLayout.PAGE_START);

        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                btn.setForeground(Color.RED);
            }
        });

        setSize(200, 80);
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}