String idValue = "[{\"link\": \"/us_new/en/home\",\"amid\": \"1__home\",\"title\": \"Home\"}, {\"link\": \"/us_new/en/home/diagnosis\",\"amid\": \"2__diagnosis\",\"title\": \"Diagnosis\"}, {\"link\": \"/us_new/en/home/loss\",\"amid\": \"3__loss\",\"title\": \"loss\",\"submenu\": [{\"amid\": \"4__quiz\",\"name\": \"quiz\",\"title\": \"quiz\"},{\"amid\": \"5__questions\",\"name\": \"questions\",\"title\": \"Questions\"}]}]";

parseJsonArray(idValue);

private void parseJsonArray(String jsonString) throws JSONException {
    System.out.println("jsonString: " + jsonString);

    JSONArray objects = new JSONArray(jsonString);
    JSONArray  nestedJsonArray;
    JSONObject  nestedJsonObject;

    for(int i = 0; i < objects.length(); i++) {
        JSONObject jsonObject = objects.getJSONObject(i);
        Iterator<String> keys = jsonObject.keys();

        while(keys.hasNext()) {
            String key = keys.next();                
            Object nestedObject = jsonObject.get(key);
            if (nestedObject instanceof JSONArray) {
                System.out.println("it's an array: " + key);
                nestedJsonArray = (JSONArray)nestedObject;
                parseJsonArray(nestedJsonArray.toString());
            }
            else if (nestedObject instanceof JSONObject) {
                nestedJsonObject = (JSONObject)nestedObject;
                System.out.printf("key : %s | value : %s | title : %s\n", key, nestedJsonObject.getString(key), nestedJsonObject.getString("title"));
            }
            else {
                System.out.printf("key : %s | value : %s | title : %s\n", key, jsonObject.getString(key), jsonObject.getString("title"));
            }
        }
    }