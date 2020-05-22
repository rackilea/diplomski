Map<String, String> map = new HashMap<String,String>();
Map<String, String> sourceType = new HashMap<String,String>();
BotrAPI api = new BotrAPI("API KEY", "API SECRET");
map.put("title", "Yureka..!!");
map.put("sourcetype", "url");
map.put("sourceformat", "youtube");
map.put("sourceurl", "https://www.youtube.com/watch?v=jebJ9itYTJE");
String output = api.makeRequest("videos/create", map); //OXm5HcGA