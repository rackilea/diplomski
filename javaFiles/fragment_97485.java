public static void main(String[] args) {
    //..
    JPanel inputPanel = createInputPane();
    //...
}

public JPanel createInputPane() {
    JPanel inputPanel = new JPanel();
    JTextField Min = new JTextField(5);
    JTextField Max = new JTextField(5);
    inputPanel.add(new JLabel("Min: "));
    inputPanel.add(Min);
    inputPanel.add(new JLabel("Max: "));
    inputPanel.add(Max);
    return inputPanel;
}