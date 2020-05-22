HashMap<String, HashMap<String, String>> myArray = new HashMap<String, HashMap<String, String>>();

if (!myArray.containsKey("en")) {
    myArray.put("en", new HashMap<String, String>());
}
myArray.get("en").put("name", "english name");