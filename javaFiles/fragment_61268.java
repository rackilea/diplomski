public void fileCreation(String fileData ) throws IOException {
    String dirName = "c:\\Shane\\Work\\Desktop\\Storage_" + Config.retrieveDate + "\\";
    File dir = new File(dirName);
    if (!dir.exists())
        dir.mkdir();

    //directory definitely exists here, we can create a file to it:

    String nameOfFile = dirName + this.nameOfFile + ".csv";
    FileWriter writeFile = new FileWriter (nameofFile);

    writeFile.append( fileData );
    writeFile.flush();
    writeFile.close();
}