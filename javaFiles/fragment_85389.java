public abstract class Something {

    abstract void doWhatever();

    @Override
    public final boolean equals(Object o) {
        return this == o;
    }

    @Override
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    @Override
    public final String toString() {
        return getClass().getName() + " " + hashCode();
    }
}