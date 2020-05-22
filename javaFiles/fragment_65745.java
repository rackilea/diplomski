public class Person
{
    public static final Comparator<Person> NAME_COMPARATOR = new NameComparator();
    public static final Comparator<Person> AGE_COMPARATOR = new AgeComparator();

    // Name, age etc properties

    private static class NameComparator implements Comparator<Person>
    {
        ...
    }

    private static class AgeComparator implements Comparator<Person>
    {
        ...
    }
}