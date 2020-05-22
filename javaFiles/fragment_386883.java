String jsonString1 = "{\n" +
                "  \"totalSize\": 4,\n" +
                "  \"done\": true,\n" +
                "  \"records\": [\n" +
                "    {\n" +
                "      \"attributes\": {\n" +
                "        \"type\": \"oppor\",\n" +
                "        \"url\": \"/service/oppor/456\"\n" +
                "      },\n" +
                "      \"AccountId\": \"123\",\n" +
                "      \"Id\": \"456\",\n" +
                "      \"ProposalID\": \"103\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Gson gson = new Gson();
        Result result1 = gson.fromJson(jsonString1, Result.class);