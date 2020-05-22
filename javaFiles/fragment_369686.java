public static Path getLogFilePath(String first, String... others) {
    if( first == null) {
        throw new IllegalArgumentException("Always a first String !!!");
    }

    Path path = Paths.get(first, others); // Compiles !
    return path;
}