public final class ImmutableObject {
    private final Collection<String> collection;
    private final Date date;

    public ImmutableObject(final Collection<String> options, final Date createdAt) {
        this.collection = ImmutableList.copyOf(options); // guava's immutable list
        this.date = new Date(date); // must be copied to prevent caller from modifying it
    }

    public Date getDate() {
        return new Date(date); // Date is mutable
    }

    public Collection<String> getCollection() {
        return collection; // already immutable copy
    }
}