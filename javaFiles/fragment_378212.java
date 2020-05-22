FileReader reader = new FileReader(filePath);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

        JSONObject jsonObject1 = (JSONObject) jsonObject.get("products");
        JSONObject jsonObject2 = (JSONObject)jsonObject1.get("productsApp15");
        String firstName = (String) jsonObject2.get("code").toString();