Map<Person, Integer> frequency = new HashMap<Person, Integer>();

for (Person person: myList2) {
    if (frequency.containsKey(person)) {
        frequency.put(person, frequency.get(person) + 1);
    } else {
        frequency.put(person, 1);
    }
}