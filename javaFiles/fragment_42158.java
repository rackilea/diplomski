JFileChooser chooser = new JFileChooser("Open");

//Set the text and language of all the components in JFileChooser
UIManager.put("FileChooser.openDialogTitleText", "Open");
UIManager.put("FileChooser.lookInLabelText", "LookIn");
UIManager.put("FileChooser.openButtonText", "Open");
UIManager.put("FileChooser.cancelButtonText", "Cancel");
UIManager.put("FileChooser.fileNameLabelText", "FileName");
UIManager.put("FileChooser.filesOfTypeLabelText", "TypeFiles");
UIManager.put("FileChooser.openButtonToolTipText", "OpenSelectedFile");
UIManager.put("FileChooser.cancelButtonToolTipText","Cancel");
UIManager.put("FileChooser.fileNameHeaderText","FileName");
UIManager.put("FileChooser.upFolderToolTipText", "UpOneLevel");
UIManager.put("FileChooser.homeFolderToolTipText","Desktop");
UIManager.put("FileChooser.newFolderToolTipText","CreateNewFolder");
UIManager.put("FileChooser.listViewButtonToolTipText","List");
UIManager.put("FileChooser.newFolderButtonText","CreateNewFolder");
UIManager.put("FileChooser.renameFileButtonText", "RenameFile");
UIManager.put("FileChooser.deleteFileButtonText", "DeleteFile");
UIManager.put("FileChooser.filterLabelText", "TypeFiles");
UIManager.put("FileChooser.detailsViewButtonToolTipText", "Details");
UIManager.put("FileChooser.fileSizeHeaderText","Size");
UIManager.put("FileChooser.fileDateHeaderText", "DateModified");

//Set icons for the JFileChooser
UIManager.put("FileView.directoryIcon", new ImageIcon(FileSystem.class.getResource("folder.png")));
UIManager.put("FileChooser.homeFolderIcon", new ImageIcon(FileSystem.class.getResource("user-home.png")));
UIManager.put("FileView.computerIcon", new ImageIcon(FileSystem.class.getResource("computer.png")));
UIManager.put("FIleView.floppyDriveIcon", new ImageIcon(FileSystem.class.getResource("media-floppy.png")));
UIManager.put("FileView.hardDriveIcon", new ImageIcon(FileSystem.class.getResource("drive-harddisk.png")));
UIManager.put("FileView.fileIcon", new ImageIcon(FileSystem.class.getResource("file.png")));
UIManager.put("FileChooser.upFolderIcon", new ImageIcon(FileSystem.class.getResource("go.png")));
UIManager.put("FileChooser.newFolderIcon", new ImageIcon(FileSystem.class.getResource("folder-new.png")));
UIManager.put("FileView.fileIcon", new ImageIcon(FileSystem.class.getResource("file.png")));
UIManager.put("FileChooser.listViewIcon", new ImageIcon(FileSystem.class.getResource("listIcon.png")));
UIManager.put("FileChooser.detailsViewIcon", new ImageIcon(FileSystem.class.getResource("details.png")));

//Update UI
SwingUtilities.updateComponentTreeUI(chooser);