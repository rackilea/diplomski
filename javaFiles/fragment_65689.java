String[] options = {"OK"};
JPanel panel = new JPanel();
JLabel lbl = new JLabel("Enter Your name: ");
JTextField txt = new JTextField(10);
panel.add(lbl);
panel.add(txt);
int selectedOption = JOptionPane.showOptionDialog(null, panel, "The Title", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);

if(selectedOption == 0)
{
    String text = txt.getText();
    // ...
}