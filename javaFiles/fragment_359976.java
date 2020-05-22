public class JWindowTest extends JFrame {

    JWindow window = new JWindow();
    JButton maxMinButton = new JButton("Minimize Window");

    public JWindowTest() {
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        maxMinButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (window.isVisible()) {
                    maxMinButton.setText("Restore Window");
                } else {
                    maxMinButton.setText("Minimize Window");
                }
                window.setVisible(!window.isVisible());
            }
        });

        add(maxMinButton);

        window.setBounds(30, 30, 300, 220);
        window.setLocationRelativeTo(this);
        window.add(new JLabel("Test JWindow", JLabel.CENTER));
        window.setVisible(true);
    }

    public static void main(String[] args) {
        new JWindowTest().setVisible(true);
    }
}