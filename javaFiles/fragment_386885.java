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
        Object object = gson.fromJson(jsonString1, Object.class);
        Map<String, String> stringMap = (Map<String, String>) object;
        Result myResult = new Result();
        Iterator entries = stringMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            switch (key) {
                case "totalSize":
                    myResult.totalSize = (int) Double.parseDouble(entry.getValue().toString());
                    break;
                case "done":
                    myResult.done = Boolean.valueOf(entry.getValue().toString());
                    break;
                case "records":
                    try{
                        Object object1 = entry.getValue();
                        List<Object> objectList = (List<Object>) object1;
                        Map<String, Object> stringMap2 = (Map<String, Object>) objectList.get(0);
                        Map<String, String> recordMap = new HashMap<>();
                        Iterator entries2 = stringMap2.entrySet().iterator();
                        while (entries2.hasNext()) {
                            Map.Entry entry2 = (Map.Entry) entries2.next();
                            String key2 = entry2.getKey().toString();
                            String value2 = entry2.getValue().toString();
                            if (!"attributes".equals(key2)) {
                                recordMap.put(key2, value2);
                            }
                            entries2.remove();
                        }
                        myResult.records = recordMap;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
            entries.remove();
        }