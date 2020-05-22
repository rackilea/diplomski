class InOutLists extends JComponent{

    InOutLists(){
        setBackground(new Color(51, 102, 255));
        setPreferredSize(new Dimension(100, 100));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel label = new JLabel("Label 1");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(label, gbc);

        JButton btn = new JButton("Back");
        gbc.gridy = 1;
        add(btn, gbc);
    }
}