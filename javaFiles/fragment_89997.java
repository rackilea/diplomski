public Set<Person> getWithNameNaive(String name){
    Set<Person> result = new HashSet<Person>();
    for(Person person: personMap.values()){
        if(person.name.equals(name)){
            result.add(person);
        }
    }
    return result;