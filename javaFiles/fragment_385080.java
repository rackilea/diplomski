File file = fileChooser.getSelectedFile();
PrintWriter writer = new PrintWriter(file);
try {
    writer.println(txtField1.getText().trim());
    writer.flush();
} finally {
    writer.close();
}