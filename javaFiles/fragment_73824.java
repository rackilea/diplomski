JFileChooser fc = new JFileChooser();
switch (fc.showOpenDialog(null)) {
    case JFileChooser.APPROVE_OPTION:
        File file= fc.getSelectedFile();
        break;
}