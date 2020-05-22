try {
    String fileName = "SOME_UNIQUE_NAME_PER_FILE";
    String localFile = dirName + "/" +filename;
    OutputStream output = new BufferedOutputStream(newFileOutputStream(localFile));
}
catch(Exception e) {
    e.printStackTrace();
}