public static void main(String[] args) {
    // Directory path here
    String path = "\\\\server\\shared_folder"; 

    String files;
    File folder = new File(path);
    File[] listOfFiles = folder.listFiles(); 

    for(int i = 0; i < listOfFiles.length; i++){
        if(listOfFiles[i].isFile()){
            files = listOfFiles[i].getName();
            System.out.println(files);
        }
    }
}