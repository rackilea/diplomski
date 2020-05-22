try{
    BufferedReader txtReader = new BufferedReader (new FileReader ("test.txt"));
    while (true) {
        // Reads one line.
        println(txtLine);
        txtLine = txtReader.readLine();
        // check after we read the value of txtLine
        if(txtLine == null){
            break;
        }

        nLines(txtLine);
    }
    txtReader.close();
} catch (IOException ex) {
    throw new ErrorException(ex);   
}