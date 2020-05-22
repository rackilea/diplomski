JTextField textField = (JTextField)e.getSource();
JFileChooser fc = new JFileChooser(...);
int returnVal = fc.showOpenDialog(textField);

if (returnVal == JFileChooser.APPROVE_OPTION) 
{
        File file = fc.getSelectedFile(); 
        textField.setText( file.toString() );
}