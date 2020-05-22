JsonPath.from("{\"payload\": {\n" +
                "    \"mimeType\": \"multipart/alternative\",\n" +
                "    \"headers\": [\n" +
                "       {\n" +
                "            \"name\": \"Mime-Version\",\n" +
                "            \"value\": \"1.0\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Subject\",\n" +
                "            \"value\": \"Welcome!\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"To\",\n" +
                "            \"value\": \"Jane Doe <xyz@xyz.com>\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Message-ID\",\n" +
                "            \"value\": \"<123456.abc.com>\"\n" +
                "        }\n" +
                "    ]\n" +
                "}}")
    .getString("headers.find{ it.name == 'Subject' }.value");
// returns "Welcome!"