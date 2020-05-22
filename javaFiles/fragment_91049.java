public class Person implements Comparable<Person> {
    ...
    @Override
    public final boolean equals(Object thatObject) {
        if (this == thatObject) {
            return true;
        }
        if (thatObject == null || getClass() != thatObject.getClass()) {
            return false;
        }
        final Person that = (Person) thatObject;
        return Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }
    ...
}