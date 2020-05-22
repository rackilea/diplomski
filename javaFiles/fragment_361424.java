JFileChooser chooser = new JFileChooser();

chooser.setCurrentDirectory(new java.io.File("."));
chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
chooser.showOpenDialog(frame);

File selectedFile = chooser.getSelectedFile();
if (selectedFile == null) {
    System.out.println("No file selected!");
    path = "";
}
else {
    path = selectedFile.getPath();
}