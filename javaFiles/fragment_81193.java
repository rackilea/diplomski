private static List<GameItem> readGameItemsFromFile(final File file)
        throws IOException {
    try ( final InputStream inputStream = new FileInputStream(file);
          final Reader reader = new BufferedReader(new InputStreamReader(inputStream)) ) {
        // Note that this .fromJson overload:
        // - does not require an intermediate string to be collected and then parsed (a common misuse of Gson parsing facilities)
        // - specifies the target list element type because List.class is just a class, 
        return gson.fromJson(reader, listOfGamesTypeToken.getType());
    }
}

private static void writeGameItemsToFile(final List<GameItem> gameItems, final File file)
        throws IOException {
    try ( final OutputStream outputStream = new FileOutputStream(file);
          final Writer writer = new BufferedWriter(new OutputStreamWriter(outputStream)) ) {
        // Note that this .toJson overload:
        // - allows to "calibrate" the source list type more precisely
        // - does not require an intermediate JSON string collected into memory and then flushed to a file (another common misuse)
        gson.toJson(gameItems, listOfGamesTypeToken.getType(), writer);
    }
}

public static void main(final String... args)
        throws IOException {
    final File file = new File("gameItems.json");
    final List<GameItem> gameItems = readGameItemsFromFile(file);
    // ... process the game items here ...
    writeGameItemsToFile(gameItems, file);
}