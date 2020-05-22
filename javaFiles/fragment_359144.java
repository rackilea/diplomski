//creating the data structure
Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();

//adding data
map.put( "key", new HashMap<String, String>() ); //adding category
map.get("key").put("nested_key", "value"); //adding TO the category

//reading entries
map.get( "key" )).get( "nested_key" );