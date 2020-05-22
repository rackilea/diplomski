String country = "1";
String state = "1";
String separator = "-" // You could use any separator
String key = country + separator + state;
Set<String> cities = new HashSet<String>();
cities.add("1");
cities.add("2");

Map<String, Set<String>> map = new HashMap<>(); 
map.put(key, cities);