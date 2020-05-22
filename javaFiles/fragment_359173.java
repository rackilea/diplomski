List<Person> persons = Arrays.asList(
    new Person("Tom","White"),
    new Person("Mark",null  ),
    new Person("Tom","Brown"),
    new Person("John","Doe" ),
    new Person("Tom","Black"),
    new Person("John",null  ),
    new Person("Tom",null));

    Map<String,Person> pmap = new TreeMap<String,Person>();

    for (Person p : persons) {
        Person other = pmap.get(p.firstName);
        if(other==null || other.lastName==null){
            pmap.put(p.firstName, p);
        }
    }
    System.out.println(pmap.values());