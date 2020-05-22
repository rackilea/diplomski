public File setFile(String filepath){
    try{
        jpegFile = new File(filepath);
    }
    catch (IOException e) {
        e.PrintStackTrace();
    }
    return jpegFile;
}