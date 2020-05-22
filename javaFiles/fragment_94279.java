String json = "{'car':['BMW', 'AUDI'],'OS':['Mac', 'Win', 'Ubuntu'],'food':['Burger', 'Taco']}";

// Convert the JSON String in a LinkedHashMap (to keep the insertion order)
Map<String, List<String>> map = new Gson().fromJson(json, new TypeToken<LinkedHashMap<String, List<String>>>(){}.getType());

// Print it, for proof
map.forEach((k, v) -> System.out.println("k = " + k + " | v = " + v));