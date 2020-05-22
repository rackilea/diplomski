javax.swing.JFileChooser jfc = new javax.swing.JFileChooser();
jfc.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
jfc.setFileFilter(new javax.swing.filechooser.FileFilter(){
    @Override
    public boolean accept(java.io.File file){
        //return (file.isDirectory() && file.getName().equals("Hello")) || !file.isDirectory(); 
        // Get only hello folder and .py files
        //return (file.isDirectory() && file.getName().equals("Hello")) || (!file.isDirectory() && file.getName().toLowerCase().endsWith(".py"));
        // Get only hello folder and .java files if Hello folder is opened else .py files
        return (file.isDirectory() && file.getName().equals("Hello")) || 
        (!file.isDirectory() && file.getParentFile().getName().equals("Hello") && 
        file.getName().toLowerCase().endsWith(".java")) || 
        (!file.isDirectory() && file.getName().toLowerCase().endsWith(".py"));
    }
    @Override
    public String getDescription() {
        return "Hello Folder and Other Files";
    }
});