Iterator<Person> iterator = people.iterator();
while(iterator.hasNext()) {
    persons.add(iterator.next());
}
people.clear();
people.addAll(persons); //Now, your people does not contain duplicate names