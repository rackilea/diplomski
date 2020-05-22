Map <String, Image> nameToImage = new HashMap<>();
public void addDefaultImages(){
    this.addAndRecurseDirectoryOfImages(DEFAULT_IMAGE_DIRECTORY);
}

public void addAndRecurseDirectoryOfImages(String directory) {
    File folder = new File(directory);
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
        if (listOfFiles[i].isFile()) {
            nameToImage.put(listOfFiles[i].getName(), new Image(directory + "/" + listOfFiles[i].getName());
        } else if (listOfFiles[i].isDirectory()) {
            addAndRecurseDirectoryOfImages(directory + "/" + listOfFiles[i].getName());
        }
    }
}