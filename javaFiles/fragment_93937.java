String data = "{\"time\": {\"1427817600000\": 90,\"1427904000000\": 134,\"1427990400000\": 155,\"1428076800000\": 167}}";

JSONObject json=new JSONObject(data);   
JSONObject timeJSON=json.getJSONObject("time");

Iterator<String> keys=timeJSON.keys();
while (keys.hasNext()){
 System.out.println(timeJSON.get(keys.next()));
}