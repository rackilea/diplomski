Predicate<Person> predicate = new Predicate<Person>() {
        @Override
        public boolean apply(Person person) {
            return person.age >= 18;
        }
    };
Collection<Person> result = Collections2.filter(persons, predicate);