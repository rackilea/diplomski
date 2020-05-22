FileReader reader = new FileReader(filePath);
    JSONParser jsonParser = new JSONParser();
    JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
    System.out.println(jsonObject);

    JSONObject idObj = (
       (JSONObject) (
             (JSONObject) (
                (JSONObject)
                   jsonObject.get("Added")
             ).get("newmem")
       ).get("IDNew")
    );

    idObj.put("id", 98009809);
    System.out.println("After ID value updated : "+jsonObject);