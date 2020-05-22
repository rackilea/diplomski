public class Test extends JFrame {

    Test() {

        JPanel main = new JPanel(new GridLayout(0, 1));
        for (int i = 0; i < 20; i ++)
            main.add(new IssuePanel());

        getContentPane().add(new JScrollPane(main));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class IssuePanel extends JPanel {

        IssuePanel() {

            setBorder(new LineBorder(Color.BLUE));
            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            JLabel topLeft = new JLabel("Top Left");
            topLeft.setOpaque(true);
            topLeft.setBackground(Color.RED);
            c.gridx = 0;
            c.gridy = 0;
            add(topLeft, c);

            JLabel topRight = new JLabel("Top Right");
            topRight.setOpaque(true);
            topRight.setBackground(Color.GREEN);
            c.gridx = 1;
            c.gridy = 0;
            add(topRight, c);

            JLabel middle = new JLabel("Middle");
            middle.setOpaque(true);
            middle.setBackground(Color.YELLOW);
            c.gridwidth = GridBagConstraints.REMAINDER;
            c.gridx = 0;
            c.gridy = 1;
            add(middle, c);

            JButton button = new JButton("Button");
            button.setOpaque(true);
            button.setBackground(Color.ORANGE);
            c.gridx = 0;
            c.gridy = 2;
            add(button, c);
        }
    }

    public static void main(String[] args) {

        new Test();
    }
}