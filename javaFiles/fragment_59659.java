File selectedFile = chooser.getSelectedFile();

// If file is not selected, show error message
if (selectedFile == null)
{
    JOptionPane.showMessageDialog(null, "PLEASE SELECT 1 FILE!", "Error", JOptionPane.ERROR_MESSAGE); 
} else {
    String fileToPath = selectedFile.getAbsolutePath();
}