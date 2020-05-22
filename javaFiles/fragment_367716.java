public static Object doThis(Request request, Response response) {
    response.type("application/json");

    JSONObject jo = new JSONObject();
    jo.put("data", "someData");
    return jo;
}