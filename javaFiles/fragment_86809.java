for (Person person : this.personMap.values()) {
    String name = person.getName();
    if (name.toLowerCase().contains(query.toLowerCase())) {
        listOfPeople.add(person);
    }
}