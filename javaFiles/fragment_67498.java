public static void main(String[] args) 
            String json = "[{\"key\":\"px\",\"mKeyValues\":[{\"hmKey\":\"qx\",\"value\":\"[{\\\"name\\\":\\\"Test Equipment value\\\",\\\"status\\\":\\\"2\\\"}]\"}]}]";
            System.out.println(json);
            JsonParser jsonParser = new JsonParser();
            JsonArray jsonObject = jsonParser.parse(json).getAsJsonArray();
            JsonObject mKeyValues0 = jsonObject.get(0).getAsJsonObject()
                    .get("mKeyValues").getAsJsonArray()
                    .get(0).getAsJsonObject();


            mKeyValues0.add("value", jsonParser.parse(mKeyValues0.get("value").getAsString() ));

            System.out.println(jsonObject);
        }