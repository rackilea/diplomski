public static class TheHandler implements ActionListener{
    String filePath;        

    public void actionPerformed(ActionEvent event){              
        String innerPath = null;
        innerPath = getFilePath();
        if (innerPath != null) {
            filePath = innerPath;
            ImagePlus picture = IJ.openImage(filePath); 
            picture.show();                                                                             
        }               
    }

    public String getFilePath() {
        String innerFilePath = null;
        Component parent = null; // better to avoid this
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TIFF Images", "tif","tiff");
        chooser.setFileFilter(filter);      
        int returnVal = chooser.showOpenDialog(parent);   
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            innerFilePath = chooser.getSelectedFile().toString();                                               
        }  
        return innerFilePath;
    }
}