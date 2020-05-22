private static final String TEST_JSON_2 = "{\n" +
        "  \"data\": \"some data\",\n" +
        "  \"social\": [\n" +
        "  ]\n" +
        "}";

...

    Type type = new TypeToken<Map<String, Object>>(){}.getType();
    final Map<String, Object> socialLinks4 = gson.fromJson(TEST_JSON_2, type);
    System.out.println(socialLinks4);

    final Map<String, Object> socialLinks5 = gson.fromJson(TEST_JSON, type);
    System.out.println(socialLinks5);