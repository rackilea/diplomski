private File prepareFile(String rawFirstFile) throws FileNotFoundException, IOException {

    File tempFile = new File("rawFirstFile_temp.dat");

    try(BufferedReader br = Files.newBufferedReader(new File(rawFirstFile).toPath());
        BufferedWriter wr = Files.newBufferedWriter(tempFile.toPath(), StandardOpenOption.WRITE)){

        String line = null;

        while ((line = br.readLine()) != null) {
            //
            // change the raw line, save filtered data as new line in your temp file
            // what ever you want. example:
            //      title1,seq1
            //      title2,seq2
            //      ...
            //
            wr.write(changeLine(line));
            wr.newLine();
        }
        return tempFile;
    }
}

public void compareFiles(String firstFile, String seconFile) throws FileNotFoundException, IOException{

    File tempFirstFile  = prepareFile(firstFile);
    File secondFile     = new File(seconFile); // maybe need to prepare too

    try(BufferedReader  br1 = Files.newBufferedReader(tempFirstFile.toPath());
        BufferedReader  br2 = Files.newBufferedReader(secondFile.toPath())){

        String line1File = null;
        String line2File = null;

        // line by line
        while ((line1File = br1.readLine()) != null && (line2File = br2.readLine()) != null ) {
            //
            // compare them
            //
        }
    } finally {
        if(tempFirstFile != null){
            //tempFirstFile.deleteOnExit(); 
            Files.delete(tempFirstFile.toPath()); // has no effect if deleteOnExit was called!
        }
    }

}

private String changeLine(String rawLine) {
    //TODO
    return rawLine;
}