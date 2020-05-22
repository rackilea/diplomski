Map<String,PlayerObject> players=new HashMap<String,PlayerObject>();
for(Map<String, PlayerObject> m:map.get("players_test")){
   for(String key:m.keySet()){
       players.put(key, m.get(key));
   }
}
System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(players));