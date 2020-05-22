SortedSet<Person> persons = new TreeSet<Person>(new Comparator<Person>() {
    @Override
    public int compare(Person arg0, Person arg1) {
        return arg0.getName().compareTo(arg1.getName());
    }
});