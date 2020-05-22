public class Person implements Comparable<Person> {
    ...
    @Override
    public final int compareTo(final Person that) {
        if (Objects.equals(getFirstName(), that.getFirstName())) {
            return getLastName().compareTo(that.getLastName());
        }
        return getFirstName().compareTo(that.getFirstName());
    }
    ...
}