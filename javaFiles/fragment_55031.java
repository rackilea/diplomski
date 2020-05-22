JComboBox comboFont;
JLabel label = new JLabel("label");
String fontString = "ariel";
int fontWeight = Font.PLAIN;
int fontSize = 16;
Font font = new Font(fontString, fontWeight, fontSize);
Color textColor = Color.BLACK

public JPanel contentPane() {
    comboFont = new JComboBox(fontStrings);
    comboFont.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            fontString = (String)comboFont.getSelectedItem();
            font = new Font(fontString, fontWeight, fontSize);
            label.setFont(font);
        }
    });
}