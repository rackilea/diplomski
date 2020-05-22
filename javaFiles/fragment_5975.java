public class TestPane extends JPanel {

    public TestPane() {
        setLayout(new GridBagLayout());
        setStartButton();
    }

    public void setStartButton() {

        JButton button = new JButton("START");
        button.setMargin(new Insets(20, 20, 20, 20));

        // color of start button
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(BLACK);
        button.setForeground(WHITE);

        // font
        button.setFont(new Font("Arial", Font.PLAIN, 8));
        add(button);

    }

}