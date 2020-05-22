File save = new File("/home/bekk");
if (!save.exists()) {
    JOptionPane.showMessageDialog(this, save + " does not exist", "Error", JOptionPane.ERROR_MESSAGE);    
} else if (!save.isDirectory()) {
    JOptionPane.showMessageDialog(this, save + " is not a directory", "Error", JOptionPane.ERROR_MESSAGE);    
}