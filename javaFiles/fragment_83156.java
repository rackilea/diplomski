Path sourcePath = Paths.get(infaFileOut);
Path destinationPath = Paths.get(fileOut);
try{
Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
} catch (IOException e) {
    //this is where the error will be thrown if the file did not move properly 
    //(null pointer etc...), you can place code here to run if there is an error
    e.printStackTrace();
}