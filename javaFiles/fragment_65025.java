public class TimmedIntentSet<T extends Timmed & Intent> implements Set<T> {


    private Set<T> set = new HashSet<>();

    // consider defining constructors other than the default

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }
    // ... more delegator methods
}