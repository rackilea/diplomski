File path = new File("MyFilesFolder");
List imageCollection = new ArrayList();
File [] files = path.listFiles();
for (int i = 0; i < files.length; i++){
    if (files[i].isFile()){ //this line weeds out other directories/folders
        imageCollection.add(loadImage(files[i]));
    }
}