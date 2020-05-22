public static void listFilesAndFilesSubDirectories(File directoryName) throws Exception {

    for(File file : directoryName.listFiles()) {
        if(file.isDirectory())
            listFilesAndFilesSubDirectories(file);
        else if(file.isFile())
            System.out.println(file.getName());
    }
}