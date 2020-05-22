final class ImmutableClass {
    private final long d;

    public ImmutableClass(Date d) {
        this.d = (d != null) ? d.getTime() : 0;
    }

    public Date getD() {
        return new Date(d);
    }
}