class InOutLists extends JComponent{

    InOutLists(){
        setBackground(new Color(51, 102, 255));
        setPreferredSize(new Dimension(100, 100));
        setLayout(new FlowLayout()); //set a layout manager to JComponent
        JPanel backPanel = new JPanel(new GridBagLayout());
        JPanel p1 = new JPanel();
        JLabel label = new JLabel("Label 1");
        JButton btn = new JButton("Back");

        p1.add(btn);
        p1.add(label);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        backPanel.add(p1, gbc);

        add(backPanel);//add backPanel to JComponent
    }
}