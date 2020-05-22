// Reusable named class (Java 1.2+)
public final class FirstNameComparator implements Comparator<Name> {
    @Override
    public int compare(Name n1, Name n2) {
        return n1.getFirstName().compareTo(n2.getFirstName());
    }
}

// Then use it like this:
this.directory = new TreeMap<Name, Integer>(new FirstNameComparator());