final JFileChooser fileChooser = new JFileChooser();
fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
fileChooser.addMouseListener(new MouseListener() {

    @Override
    public void mouseClicked(MouseEvent arg0) {

        if(arg0.getClickCount() == 2) {
            File file = fileChooser.getSelectedFile();
            if(file.isDirectory()) {
                fileChooser.setCurrentDirectory(file);
                fileChooser.rescanCurrentDirectory();
            }
            else {
                fileChooser.approveSelection();
            }
        }
    }

    //Other methods (can be empty)  
});