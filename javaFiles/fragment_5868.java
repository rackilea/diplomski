Map<String, String> map = new HashMap<String, String>();
map.put("145", "PentHouse");
map.put("125", "BoardRoom");
map.put("145", "PentHouse");
// etc

String room = map.get("8");
// room will be null if "8" isn't a key in the map.