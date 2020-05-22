public static void main(String[] args) throws Exception {
    String jsonStr = "{         \"dataArray\": [{              \"A\": \"a\",                \"B\": \"b\",               \"C\": \"c\"            }, {                \"A\": \"a1\",              \"B\": \"b2\",              \"C\": \"c3\"           }]      }";

    JSONObject jsonObj = new JSONObject(jsonStr);

    JSONArray c = jsonObj.getJSONArray("dataArray");
    for (int i = 0 ; i < c.length(); i++) {
        JSONObject obj = c.getJSONObject(i);
        String A = obj.getString("A");
        String B = obj.getString("B");
        String C = obj.getString("C");
        System.out.println(A + " " + B + " " + C);
    }
}