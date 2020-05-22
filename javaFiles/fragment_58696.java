public static void main(String[] args){
    boolean goodFile = false;

    while (!goodFile){
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog();

        goodFile = processFile(chooser.getSelectedFile());
    }
}

private boolean processFile(File file){
    //do you stuff with the file

    //return true if the processing works properly, and false otherwise    
}