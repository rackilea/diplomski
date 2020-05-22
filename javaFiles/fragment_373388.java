void processDirectory (File directory){
    if (directory.isDirectory()){
        File[] fileList = directory.listFiles();
        for (File f:fileList){
            processDirectory(f);
        }

    }else{
        System.out.println(directory.getAbsolutePath());
        Platform.runLater(() -> status.set(directory.getAbsolutePath()));
    }

}