public class BadLayout04 {

    public static void main(String[] args) {
        new BadLayout04();
    }

    public BadLayout04() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new ButtonsPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ButtonsPane extends JPanel {

        public ButtonsPane() {

            JPanel group1 = createGroup(1);
            JPanel group2 = createGroup(5);
            JPanel group3 = createGroup(9);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(group1, gbc);
            gbc.gridx = 1;
            add(group2, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(group3, gbc);

        }

        public JPanel createGroup(int index) {

            JPanel group = new JPanel(new GridBagLayout());
            group.setBorder(new EmptyBorder(4, 4, 4, 4));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            for (int loop = 0; loop < 4; loop++) {
                group.add(new JButton("Button " + (index++)), gbc);
            }

            return group;

        }

    }

}