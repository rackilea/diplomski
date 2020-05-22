final JFileChooser fc = new JFileChooser();
    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int userSelection = fc.showSaveDialog(null);
    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File f = fc.getSelectedFile();
        String name = f.getAbsolutePath();
        File newFile = new File(name + "\\" + yourfilenamehere);//the text is written on this file.
    }