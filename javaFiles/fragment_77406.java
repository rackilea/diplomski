public abstract class PersonComparator implements Comparator<Person> {
    private final boolean isReversed;

    private PersonComparator(boolean isReversed) {
        this.isReversed = isReversed;
    }

    public boolean isReversed() {
        return isReversed;
    }

    @Override
    public int compare(Person lhs, Person rhs) {
        return isReversed ? compareImpl(rhs, lhs) : compareImpl(lhs, rhs);
    }

    public abstract String getComparison();
    protected abstract int compareImpl(Person lhs, Person rhs);

    public static final class Name extends PersonComparator {
        private Name(boolean isReversed) { super(isReversed); }
        @Override
        protected int compareImpl(Person lhs, Person rhs) {
            return lhs.getName().compareTo(rhs.getName());
        }
        @Override
        public String getComparison() {
            return "Name";
        }
    }

    public static final Name NAME         = new Name(false);
    public static final Name NAME_REVERSE = new Name(true);
}