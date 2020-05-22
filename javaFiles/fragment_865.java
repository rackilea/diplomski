// create a map that maps abbreviated strings to their replacement text
Map<String, String> abbreviationMap = new HashMap<String, String>();

// populate the map with some values
abbreviationMap.put("str", "string");
abbreviationMap.put("bin", "binary");
abbreviationMap.put("txt", "text");

// get a string from the database and replace it with the value from the map
String fromDB = // get string from database
String fullText = abbreviationMap.get(fromDB);