String inputString = "one=1&two=2";
Map<String, String> map = parseMap(inputString);

//your code to print the map again
Set<String> keys = map.keySet();

for(String key : keys) {
  System.out.print("\"" + key + "\""  + ":" + "\"" + map.get(key) + "\"");
}