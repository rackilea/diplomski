final JFrame iFRAME = new JFrame();
iFRAME.setAlwaysOnTop(true);    // ****
iFRAME.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
iFRAME.setLocationRelativeTo(null);
iFRAME.requestFocus();

JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
int returnValue = jfc.showOpenDialog(iFRAME);
iFRAME.dispose();
if (returnValue == JFileChooser.APPROVE_OPTION) {
    File selectedFile = jfc.getSelectedFile();
    // Display selected file in console
    System.out.println(selectedFile.getAbsolutePath());
}
else {
    System.out.println("No File Selected!");
}