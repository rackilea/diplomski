JFileChooser fc = new JFileChooser(){

        @Override
        public void approveSelection(){
            File f = getSelectedFile();
            if(!f.exists() ){                   
                JOptionPane.showMessageDialog(null, "Error");                   
            }
        }           
    };

    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    fc.setDialogTitle("Open test");
    fc.removeChoosableFileFilter(fc.getFileFilter());  //remove the default file filter
    FileFilter filter = new FileNameExtensionFilter("XML file", "xml");

    fc.addChoosableFileFilter(filter); //add XML file filter

    //show dialog
    int returnVal = fc.showOpenDialog(appFrame); 

    if(returnVal == JFileChooser.APPROVE_OPTION){/* ...  */}