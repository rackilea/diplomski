public class TestPane extends JPanel {

    public TestPane() {

        setLayout(new BorderLayout(0, 4));

        JPanel core = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        JTextArea patch = new JTextArea(10, 20);

        core.add(new JScrollPane(patch), gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 8, 2, 4);
        gbc.anchor = GridBagConstraints.NORTH;
        for (int index = 0; index < 6; index++) {
            core.add(new JButton("Button #" + index), gbc);
            gbc.gridy++;
        }

        add(core);
        JButton playButton = new JButton("Play >");
        playButton.setMargin(new Insets(12, 12, 12, 12));
        add(playButton, BorderLayout.SOUTH);

    }

}