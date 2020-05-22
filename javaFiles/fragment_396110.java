HashMap<String, String> dataMessages = new HashMap<>();
dataMessages.put("PushMessage", Integer.toString(pushMessage));
...
Type stringStringMap = new TypeToken<Map<String, String>>() {
}.getType();
Gson gson = new Gson();
//String dataMessageString = gson.toJson(dataMessages, stringStringMap);

JsonElement dataElement = gson.toJsonTree(dataMessages, stringStringMap); //ADDED
...
JsonObject jsonObject = new JsonObject();
...
jsonObject.add("data", dataElement); //CHANGED

Log.d(TAG, "gsonTest: " + jsonObject.toString()); //DEBUG
...