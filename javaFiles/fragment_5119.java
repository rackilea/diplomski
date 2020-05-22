private static final Gson gson = new Gson();

public static void main(final String... args)
        throws IOException {
    for ( final String resource : ImmutableList.of("single.json", "list.json") ) {
        try ( final JsonReader jsonReader = getPackageResourceJsonReader(Q43412261.class, resource) ) {
            final Model model = gson.fromJson(jsonReader, Model.class);
            System.out.println(model);
        }
    }
}