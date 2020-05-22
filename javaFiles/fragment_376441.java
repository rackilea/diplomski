class PlayerObject {
    private String uuid;
    private String name;
    private String signup_time;
    // getters & setters
}

Gson gson = new Gson();
Type type = new TypeToken<Map<String, ArrayList<Map<String, PlayerObject>>>>(){}.getType();
Map<String, ArrayList<Map<String, PlayerObject>>> map = gson.fromJson(jsonString, type);