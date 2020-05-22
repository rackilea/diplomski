try {
    Scanner scan = new Scanner(new File("file.txt"));

    while (scan.hasNextLine()) {
        // do somethig...
    }
} catch(FileNotFoundException ex) {
    System.err.println("file.txt was not found");
}