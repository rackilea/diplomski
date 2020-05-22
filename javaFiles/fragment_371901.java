ListMultiMap<String, Person> pers =  ArrayListMultimap.create();
List<Person> persons = pers.get("Bob");
for(Person p : persons){
    if (p.getId() == 1){
        //do something
    }
}