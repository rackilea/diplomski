JFileChooser jfc = new JFileChooser();
int returnVal = jfc.showSaveDialog();

if(returnVal == JFileChooser.APPROVE_OPTION) {
    File outputFile = jfc.getSelectedFile();
    ImageIO.write(screenshot, "png", outputFile);
}