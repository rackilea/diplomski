// initially unfiltered
FilteredList<Person> filteredPersons = new FilteredList<>(allPersons);

// set containing all the predicates that need to match to keep a Person
Set<Predicate<Person>> filters = ...

// keep a person iff all filters return true for the person
Predicate<Person> predicate = person -> filters.stream().allMatch(pred -> pred.test(person));
filteredPersons.setPredicate(predicate);