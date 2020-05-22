JOptionPane.showMessageDialog(null, "Please choose a file");        
JFileChooser input = new JFileChooser();
int a = input.showOpenDialog(null);
String file = "";

if (a == JFileChooser.APPROVE_OPTION) {
    File selectedFile = input.getSelectedFile();
    file = selectedFile.getPath();
}