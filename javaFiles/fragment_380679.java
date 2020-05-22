Collections.sort(people, new Comparator<Person>() {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
});