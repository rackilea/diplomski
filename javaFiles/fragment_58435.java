Map<String, List<String>> map = new HashMap<>();
map.put("ducks", new ArrayList<String>());
map.get("ducks").add("Huey");
map.get("ducks").add("Dewey");
map.get("ducks").add("Louie");
// or as an alternative to the prev 4 lines:
// map.put("ducks", new ArrayList<String>(
//     new String[] {"Huey", "Dewey", "Louie"}));
Collection<String> ducks = map.get("ducks");
System.out.println(ducks); // [Huey, Dewey, Louie]