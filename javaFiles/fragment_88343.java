ArrayList<Person> people = . . .;
Collections.sort(people, new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            final int age1 = o1.getAge();
            final int age2 = o2.getAge();
            return age1 < age2 ? -1 : age1 > age2 ? 1 : 0;
        }
    }
);