public static void main(final String... args)
        throws IOException {
    final File file = createTempFile("q43439637_", "_q43439637");
    file.deleteOnExit();
    try ( final FileWriter fileWriter = new FileWriter(file) ) {
        final Passenger[] before = { new Passenger("Alice"), new Passenger("Bob") };
        gson.toJson(before, fileWriter);
    }
    try ( final FileReader fileReader = new FileReader(file) ) {
        final Passenger[] after = gson.fromJson(fileReader, Passenger[].class);
        for ( final Passenger p : after ) {
            System.out.println(p.name);
        }
    }
}