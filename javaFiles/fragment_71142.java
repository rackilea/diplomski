public void actionPerformed(ActionEvent arg0) {
    int returnVal = uploadChooser.showOpenDialog(Navigator.this);
    if(returnVal == JFileChooser.APPROVE_OPTION) {
        String pathToUpload = uploadChooser.getSelectedFile().getAbsolutePath();
        UploadUtil uploadIt = new UploadUtil(pathToUpload, chacha);
        uploadIt.addPropertyChangeListener(new UploadUtilListener());
        uploadIt.execute();
    }   
}