List<Person> personList = new ArrayList<>();
    personList.add(new Employee());
    personList.add(new Student());
    for ( Person p : personList ) {
        p.displayMe();
    }