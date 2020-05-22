String filename = "path/to/the/file/with/numbers.txt";
try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
    String line;
    int currentIndex = 1;
    while((line = reader.readLine()) != null) {
        // see further on how to implement the below method
        setTextFieldValue(currentIndex, line.trim());
        currentIndex++
    }
}