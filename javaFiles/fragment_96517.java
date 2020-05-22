@Test
final void test2() {
    String json = "{ \"books\": [" 
            + "                    {" 
            + "                        \"category\": \"reference\","
            + "                        \"author\": \"Nigel Rees\","
            + "                        \"book_id\": \"214515\","
            + "                        \"title\": \"Sayings of the Century\","
            + "                        \"price\": 8.95," 
            + "                        \"reviews\": ["
            + "                        {" 
            + "                          \"rating\": 2,"
            + "                          \"reviewer\": \"Amazon\"," 
            + "                          \"weight\": 0"
            + "                        }" 
            + "                      ]" 
            + "                    },"
            + "                    {" 
            + "                        \"category\": \"reference\","
            + "                        \"author\": \"Nigel Rees\","
            + "                        \"book_id\": \"314515\","
            + "                        \"title\": \"Sayings of the Century\","
            + "                        \"price\": 8.95," 
            + "                        \"reviews\": ["
            + "                        {" 
            + "                          \"rating\": 4,"
            + "                          \"reviewer\": \"Trip\"," 
            + "                          \"weight\": 5"
            + "                        }" 
            + "                      ]" 
            + "                    }"

            + "               ]" 
            + "}";

    List output = JsonPath.read(json, "$.books[*].['book_id', 'reviews'])");

    String expectedOutput = 
            "["
            + "{"
                + "\"book_id\":\"214515\","
                + "\"reviews\":["
                                + "{"
                                        + "\"rating\":2,\"reviewer\":\"Amazon\",\"weight\":0"
                                + "}"
                            + "]"
            + "},"
            + "{"
                + "\"book_id\":\"314515\","
                + "\"reviews\":["
                                + "{\"rating\":4,\"reviewer\":\"Trip\",\"weight\":5}"
                            + "]"
            + "}"
        + "]";

    assertEquals(expectedOutput, output.toString());

}