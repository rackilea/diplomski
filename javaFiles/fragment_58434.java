Multimap<String, String> multimap = ArrayListMultimap.create();   
multimap.put("ducks", "Huey");
multimap.put("ducks", "Dewey");
multimap.put("ducks", "Louie");
Collection<String> ducks = multimap.get("ducks");
System.out.println(ducks); // [Huey, Dewey, Louie]