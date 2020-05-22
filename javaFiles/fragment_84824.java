FileDialog fileDialog = new FileDialog(yourJFrame, "Choose a file", FileDialog.LOAD);
fd.setDirectory("the directory you want the dialog to be opened in");
fd.setFile("*.desiredExtension");
fd.setVisible(true);
String filename = fd.getFile();
if (filename == null)
    //your user cancelled the choise
else
    //file chosen