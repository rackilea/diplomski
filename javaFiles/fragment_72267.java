public File getCurrentFileInformation() {
        // display file dialog
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int result = fileChooser.showOpenDialog(this);

        // if  Cancel button on dialog clicked, return
        if (result == JFileChooser.CANCEL_OPTION)
            System.exit(1);

        File selectedFileName = fileChooser.getSelectedFile(); // get selected file


        if ((selectedFileName == null) || (selectedFileName.getName().equals(""))) {
            JOptionPane.showMessageDialog(this, "Invalid File Name",
                    "Invalid File Name", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // end if

        return selectedFileName;
    }