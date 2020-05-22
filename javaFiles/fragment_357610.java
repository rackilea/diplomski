static void testWithGson()
        throws IOException {
    try ( final Reader reader = stripProtection(getPackageResourceReader(Q42971905.class, "no-hijacking.json")) ) {
        final JsonParser parser = new JsonParser();
        final JsonElement jsonElement = parser.parse(reader);
        System.out.println(jsonElement);
    }
}

static void testWithJackson()
        throws IOException {
    try ( final Reader reader = stripProtection(getPackageResourceReader(Q42971905.class, "no-hijacking.json")) ) {
        final ObjectMapper objectMapper = new ObjectMapper();
        final JsonNode jsonNode = objectMapper.readTree(reader);
        System.out.println(jsonNode);
    }
}

static void testWithOrgJson()
        throws IOException {
    try ( final Reader reader = stripProtection(getPackageResourceReader(Q42971905.class, "no-hijacking.json")) ) {
        final JSONTokener jsonTokener = new JSONTokener(reader);
        final Object value = jsonTokener.nextValue();
        System.out.println(value);
    }
}