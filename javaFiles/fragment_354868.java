try{
    BufferedReader txtReader = new BufferedReader (new FileReader ("test.txt"));
    while ((txtLine = txtReader.readLine()) != null) {
        // Reads one line.
        println(txtLine);
        nLines(txtLine);
    }
    txtReader.close();
} catch (IOException ex) {
    throw new ErrorException(ex);   
}