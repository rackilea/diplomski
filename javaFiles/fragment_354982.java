String jsonString = "{\"status_code\": 200,\"status_message\": \"OK\",\"response\":{\"applications\":{\"345\": \"A\",\"125\": \"B\",\"458\": \"C\",\"434\": \"D\",\"512\": \"E\",\"645\": \"F\"}}}";
JsonPath jsonPath = new JsonPath(jsonString);
Map<String, String> applicationsMap = jsonPath.getMap("response.applications");
Set<String> applicationKeys = applicationsMap.keySet();
for(String key:applicationKeys){
    System.out.println("Key value: " + key + ", Element value: " + applicationsMap.get(key));
}