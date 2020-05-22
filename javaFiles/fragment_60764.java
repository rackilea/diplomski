public static void numberDuplicateLastNames(List<Person> people) {
    HashMap<String, Integer> duplicatedLastNames = new HashMap<>();
    for(Person p : people) {
        if(! duplicatedLastNames.containsKey(p.lastName)) {
            duplicatedLastNames.put(p.lastName, 1);
            p.index = 1;
        } else {
            int i = duplicatedLastNames.get(p.lastName) + 1;
            duplicatedLastNames.put(p.lastName, i);
            p.index = i;
        }
    }

    //Remove index from the people who don't have a duplicate last name
    for(Person p : people) {
        if (duplicatedLastNames.get(p.lastName) == 1) {
            p.index = 0;
        }
    }
}