private void processImages(List<Path> sourceList) throws IOException { 
    //create same method but for CSV without using GridFS
    for (Path file : sourceList) {
        if (file.getFileName().toString().endsWith(".png")) {

    System.out.println(ImageDriver.uploadImage(file.toAbsolutePath()));