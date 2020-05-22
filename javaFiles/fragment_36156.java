JFileChooser save = new JFileChooser();  
    save.showSaveDialog(this);  
    save.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    tosave = fileChooser.getSelectedFile().getAbsolutePath(); //tosave is a String

    new CopyFile(selected,tosave);