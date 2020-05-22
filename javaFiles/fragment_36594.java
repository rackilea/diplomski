File directory = new File(directoryName);

//get all the files from a directory
File[] fList = directory.listFiles();

if(fList != null){
    for (File file : fList){
        if (file.isFile()){
            System.out.println(file.getName());
        }
    }
}