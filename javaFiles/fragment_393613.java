class (anonymous) extends javax.swing.AbstractListModel{
    URL url = getClass().getResource("friends");
    File folder = new File(url.getPath());
    File[] listOfFiles = folder.listFiles();
    String[] elements = new String[listOfFiles.length];
    for(int i=0; i<listOfFiles.length;i++) {
        elements[i] = (listOfFiles[i].getName());
}