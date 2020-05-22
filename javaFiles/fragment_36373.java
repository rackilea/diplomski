JSONArray arr = new JSONArray(
                "[{\"key\":\"a\",\"value\":\"b\"},{\"key\":\"c\"},{\"key\":\"d\",\"value\":\"e\"}]");
        for (int i = 0; i < arr.length(); i++) {

            JSONObject obj = (JSONObject) arr.get(i);
            Iterator<String> keys = obj.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                //your logic for checking if object has both keys or one key goes here
                if (key.equals("key")) {

                }
            }

        }