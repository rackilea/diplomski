input_button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        JFileChooser inputFile = new JFileChooser();
        inputfile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if (inputfile.showOpenDialog(myFrame) == JFileChooser.APPROVE_OPTION) {
            File file1 = inputFile.getSelectedFile();
            String fullpathTemp = (String) file1.getAbsolutePath();
            ...
        }
    }
});