private List<Person> filterPeople(Predicate<Person> filter){
     List<Person> persons= fillPersonsInfo();
     return persons.stream()
           .filter(filter)
           .collect(toList());
 }

 public List<Person> getPeopleOfAge(int age){
     return filterPeople(person -> person.getAge == age);
 }

 public List<Person> getPeopleOfName(String name){
     return filterPeople(person -> person.getName().equals(name));
 }