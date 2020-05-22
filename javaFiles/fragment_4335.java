String finalJson = "{  \n" +
        "\"result\":1,\n" +
        "\"data\":[  \n" +
        "{  \n" +
        "\"id\":\"1\",\n" +
        "\"langtitude\":\"31.3256632\",\n" +
        "\"latitude\":\"20.3256632\",\n" +
        "\"userNumber\":\"23\",\n" +
        "\"address\":\"adfsf\",\n" +
        "\"userFK\":\"1\"\n" +
        "},\n" +
        "{  \n" +
        "\"id\":\"2\",\n" +
        "\"langtitude\":\"31.3256632\",\n" +
        "\"latitude\":\"20.3256632\",\n" +
        "\"userNumber\":\"23\",\n" +
        "\"address\":\"adfsf\",\n" +
        "\"userFK\":\"1\"\n" +
        "}\n" +
        "]\n" +
        "}";

try {
    JSONObject reader = new JSONObject(finalJson);
    int result  = reader.getInt("result");
    JSONArray data  = reader.getJSONArray("data");

    Log.i("MYTAG", "reader:" + reader);
    Log.i("MYTAG", "result: "+result);
    Log.i("MYTAG", "data: "+data);

} catch (Exception e) {
    e.printStackTrace();
}