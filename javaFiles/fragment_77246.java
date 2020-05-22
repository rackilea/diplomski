public void init(){

    JLabel ltextBox = new JLabel("TextBox: ");

    textBox = new JTextField(10);

    JPanel leftPanel = new JPanel();
    leftPanel.add(ltextBox);
    leftPanel.add(textBox);

    JPanel rightPanel = new JPanel();
    rightPanel.add(textArea);

    textArea.setEditable(false); //<-- put it here

}