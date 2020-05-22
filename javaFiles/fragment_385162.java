// Use a list to keep track of People
List<Person> myPeople = new ArrayList<Person>();
Person steve = new Person("Steve");
myPeople.add(steve);
myPeople.add(new Person("Bob"));


// Use a Map to track Groups
Map<String, List<Person>> groups = new HashMap<String, List<Person>>();
groups.put("Everybody", myPeople);
groups.put("Developers", Arrays.asList(steve));

// Does a group contain everybody?
groups.get("Everybody").containsAll(myPeople); // returns true
groups.get("Developers").containsAll(myPeople); // returns false