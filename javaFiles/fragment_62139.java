public void newFolder(String Path, int n) {

    File folder;
    if(n==0) 
        folder = new File(Path);
    else
        folder = new File(Path +" "+ n);

    if(folder.exists()) 
        newFolder(Path, ++n);
    else
        folder.mkdir();
}