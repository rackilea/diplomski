open.addActionListener(new ActionListener(){
        public void actionPerformed (ActionEvent e){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new java.io.File("."));
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                try{
                DataOutputStream outputPath = new DataOutputStream(new FileOutputStream("C:/Users/Jonathan/Desktop/YouDetectJava/FolderPath.dat"));
                String exportPath = fileChooser.getSelectedFile() + "\\";
                outputPath.writeUTF(exportPath);
                //System.out.println(exportPath);
                }catch (IOException ioe){
                }
                }
        }
    });