BufferedWriter duplicates = new BufferedWriter(new FileWriter("sorted.txt"));
try {
    // Loop in here, writing to duplicates
} catch(IOException e) {
    // Exception handling
} finally {
    try {
        duplicates.close();
    } catch (IOException e) {
        // Whatever you want
    }
}