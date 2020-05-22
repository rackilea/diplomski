// Gson instances are thread-safe and can be easily instantiated once
private static final Gson gson = new GsonBuilder()
        .registerTypeAdapter(Operator.class, getOperatorJsonDeserializer())
        .create();

public static void main(final String... args)
        throws IOException {
    try ( final Reader reader = new InputStreamReader(EntryPoint.class.getResourceAsStream("/test.json")) ) {
        final Wrapper wrapper = gson.fromJson(reader, Wrapper.class);
        out.println(wrapper);
        // ... convert the wrapper DTO above to your target business object
    }
}