private void OpenActionPerformed(java.awt.event.ActionEvent evt)throws java.lang.NullPointerException {
    fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(null);
    if(result == JFileChooser.APPROVE_OPTION){
        File file=fileChooser.getSelectedFile();
        ImageIcon ic = new ImageIcon(file.toURI().toURL());
        j.setIcon(ic);
    }
    // ..