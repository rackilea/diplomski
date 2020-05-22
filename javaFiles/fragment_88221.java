private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    JFileChooser chooser = new JFileChooser();
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.showOpenDialog(null);
    File f = chooser.getSelectedFile();
    String SourceDir = f.getAbsolutePath();
try {

    File srcDir = new File(SourceDir);
    File destDir = new File("C:/output/");

    FileUtils.copyDirectoryToDirectory(srcDir, destDir);

}
    catch (Exception ex) {
    ex.printStackTrace();
}
}