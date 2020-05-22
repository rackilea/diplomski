enum SortOn {
    FIRSTNAME(Comparator.comparing(Person::getFirstName,
        Comparator.nullsFirst(String::compareTo))),
    LASTNAME(Comparator.comparing(Person::getLastName, 
        Comparator.nullsFirst(String::compareTo))),
    HEIGHT(Comparator.comparing(Person::getHeight, 
        Comparator.nullsFirst(Integer::compareTo))),
    BIRTHDAY(Comparator.comparing(Person::getBirthday, 
        Comparator.nullsFirst(Date::compareTo)));

    public final Comparator<Person> comparator;

    private SortOn(Comparator<Person> comparator) {
        this.comparator = comparator;
    }
}
...
public void sort(SortOn criteria1, SortOn criteria2) {
    if(criteria1 == criteria2) {
        list.sort(criteria1.comparator);
    } else {
        list.sort(criteria1.comparator.thenComparing(criteria2.comparator));
    }
}