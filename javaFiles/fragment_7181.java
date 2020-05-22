// Get the people (which are values, as opposed to keys) of the map.
Collection<Person> people = getPeople().values();

// Iterate over each person.
for (Person somePerson : people) {
    // Do something with the eye color.
    System.out.println("This eye color is " + somePerson.eyeColor);
}