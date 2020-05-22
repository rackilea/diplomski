public class Comparators {
    public static final Comparator<Person> PERSON_LEXICOGRAPHIC_COMPARATOR = new Comparator<Person>() {
        @Override
        public int compare(Person a, Person b) {
            return a.name.compareToIgnoreCase(b.name);
        }
    }

    public static final Comparator<Person> PERSON_AGE_COMPARATOR = new Comparator<Person>() {
        @Override
        public int compare(Person a, Person b) {
            return a.age < b.age ? -1 : a.age == b.age ? 0 : 1;
        }
    }
}