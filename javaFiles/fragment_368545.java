public static void main(String...strings) throws JSONException {
        String s1 = "{\"a\":\"1\",\"b\":\"2\"}";
        String s2 = "{\"c\":\"4\",\"d\":[{}]}";

        JSONObject jsonObject1 = new JSONObject(s1);
        JSONObject jsonObject2 = new JSONObject(s2);

        Iterator itr = jsonObject2.keys();

        while(itr.hasNext()) {
            String key = (String) itr.next();
            jsonObject1.put(key, jsonObject2.get(key));
        }

        System.out.println(jsonObject1.toString());

    }