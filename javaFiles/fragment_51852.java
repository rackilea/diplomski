String fileAsString = ""; // Holds all the file data as a single string.
try {    
    fileAsString = new String(Files.readAllBytes(Paths.get("test2.txt")));
}
catch (IOException ex) {
    // Inform of any errors then exit method
    System.err.println("File Error! --> " + ex.getMessage());
    return;
}