private static String readFile(String path) throws FileReadIOException {
    try {
        String lineSeparator = System.getProperty("line.separator");
        List<String> lines = Files.readAllLines(Paths.get(path));
    }
    catch (Exception e) {
        throw new FileReadIOException(e.getMessage());
   }
}

try {
    readFile(path);
    // more code
    convert(file)
} catch (FileReadIOException e) {
    // handle first exception here
} catch (SomeOtherException e) {
    // handle second exception here
}