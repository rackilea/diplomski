Person search(Person, Name)
    if (Person.Name == Name) return Person;
    for each subPerson in Person.person:
        Person found = subPerson.search(Person, Name);
        if (found != null) return found;
    return null;