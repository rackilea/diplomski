class PersonByFirstNameThenByLastNameComparator implements Comparator<Person> {
    public static final PersonByFirstNameThenByLastNameComparator INSTANCE =
            new PersonByFirstNameThenByLastNameComparator();

    private PersonByFirstNameThenByLastNameComparator() {}

    @Override
    public int compare(final Person lhs, final Person rhs) {
        if (Objects.equals(lhs.getFirstName(), rhs.getFirstName())) {
            return lhs.getLastName().compareTo(rhs.getLastName());
        }
        return lhs.getFirstName().compareTo(rhs.getFirstName());
    }
}