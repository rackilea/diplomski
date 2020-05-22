Arrays.sort(personArray, new Comparator<Person>() {
    @Override
    public int compare(Person p1, Person p2) {
        return p2.age - p1.age;
    }
});