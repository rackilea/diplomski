int value = JOptionPane.showOptionDialog(this,
                    getPanel(),
                    "Hello World",
                    JOptionPane.OK_CANCEL_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE,
                    null, null, null);

private JPanel getPanel() {
    JPanel panel = new JPanel();
    JTextField txt = new JTextField(20);
    JButton btn = new JButton("Button");

    panel.add(txt);
    panel.add(btn);

    return panel;
}