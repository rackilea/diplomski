//Get the content you want to lay down into a byte[]
byte content[] = "I am some simple content that should be written".getBytes();

//Name your entry with the complete path relative to the base directory
//of your archive. Any directories that don't exist (e.g. "testDir") will 
//be created for you
TarArchiveEntry textFile = new TarArchiveEntry("testDir/hello.txt");

//Make sure to set the size of the entry. If you don't you will not be able
//to write to it
textFile.setSize(content.length);


TarArchiveOutputStream gzOut = null;
try {

    /*In this case I chose to show how to lay down a gzipped archive.
      You could just as easily remove the GZIPOutputStream to lay down a plain tar.
      You also should be able to replace the FileOutputStream with 
      a ByteArrayOutputStream to lay nothing down on disk if you wanted 
      to do something else with your newly created archive
    */
    gzOut = new TarArchiveOutputStream(
                new GZIPOutputStream(
                new BufferedOutputStream(
                new FileOutputStream("/tmp/mytest.tar.gz")
            )));

    //When you put an ArchiveEntry into the archive output stream, 
    //it sets it as the current entry
    gzOut.putArchiveEntry(textFile);

    //The write command allows you to write bytes to the current entry 
    //on the output stream, which was set by the above command.
    //It will not allow you to write any more than the size
    //that you specified when you created the archive entry above
    gzOut.write(content);

    //You must close the current entry when you are done with it. 
    //If you are appending multiple archive entries, you only need  
    //to close the last one. The putArchiveEntry automatically closes
    //the previous "current entry" if there was one
    gzOut.closeArchiveEntry();

} catch (Exception ex) {
    System.err.println("ERROR: " + ex.getMessage());
} finally {
    if (gzOut != null) {
        try {
            gzOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}