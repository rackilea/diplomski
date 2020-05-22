Map<Person, List<String>> associations = new HashMap<Person, List<String>>();

Person steve = new Person("Steve");
Person ed = new Person("Ed");

associations.put(steve, Arrays.asList("Everybody", "Developers"));
associations.put(ed, Arrays.asList("Everybody"));

// This is the tricky part
boolean sharesGroups = checkForSharedGroups(associations, Arrays.asList(steve, ed));