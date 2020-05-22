button.addActionListener(new TextFieldSaver(textfield));

....

class TextFieldSaver implements ActionListener {
    JTextField textfield;
    public TextFieldSaver(JTextField toBeSaved) {
        textfield = toBeSaved;
    }
    public void actionPerformed(ActionEvent event) {
        String text = textfield.getText();
        textfield.setText("");
        new BufferedWriter(new FileWriter("text.txt")).write(text).newLine().close();
    }
}