@Test
    public void test() throws Exception {
        String jsonString = "{\"bool\": true,"
                + "\"str\":\"strv\","
                + "\"long\": 100000000000000}";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(jsonString , Map.class);

        assertEquals(Long.class, map.get("long").getClass());
        assertEquals(Boolean.class, map.get("bool").getClass());
    }