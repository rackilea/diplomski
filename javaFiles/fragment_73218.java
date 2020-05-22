public static void main(String[] args) throws Exception {

    // Json Stream Reader
    String jsonS = "";

    // Connect to web api
    URL url = new URL("http://b50172e8.ngrok.io/api/plugin/521100d075c1284b944841394e157744");

    // Make Connection
    URLConnection conn = url.openConnection();
    conn.setRequestProperty("Accept","*/*");
    conn.connect();

    // Stream reader
    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String inputLine;


    while((inputLine = in.readLine()) != null) {
        jsonS+=inputLine;
    }

    // Read json response
    Gson gson = new Gson();

    // Json Object
    JsonObject jsonObject= gson.fromJson(jsonS, JsonObject.class);
    JsonArray data = jsonObject.getAsJsonArray("data");

    //here data is JsonArray and it contains everithing: [{"cmd":"cmd-1"},{"cmd":"cmd-1"},{"cmd":"cmd-1"}]
    data.forEach(el -> {
        //Get Json object which has key and value -> {"cmd":"cmd-1"}
        JsonObject jo = el.getAsJsonObject();
        //get the value as Json element -> "cmd-1"
        JsonElement je = jo.get("cmd");
        //Then make the json element string
        String value = je.getAsString();
        System.out.println(value);
    });
    //System.out.println(data);

    // Close connection
    in.close();


}