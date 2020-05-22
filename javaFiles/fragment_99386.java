public void loadFiles(String folder, List<MyFile> listFiles) {
        File directory = new File(folder);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            **MyFile myfile = new MyFile();**
            if (file.isDirectory()) {
                loadFiles(file.toString());
            }
            if (file.isFile()) {
                //set name and size to myfile
                myfile.setName(file.getName());
                myfile.setSize(file.length());
                listFiles.add(myfile);
            }
        }
    }