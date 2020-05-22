Path path = Paths.get("C:\\Users\\emily\\Documents\\Parts.txt");
try {
    List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
    String[] array = lines.toArray(new String[lines.size()]);
    ...
} catch (IOException e) {
    //Logger.getLogger(getClass().getName()).log(Level.SEVERE,
    //                                           path.toString(), e);
    System.err.println("Could not read file: " + e.getMessage());
}