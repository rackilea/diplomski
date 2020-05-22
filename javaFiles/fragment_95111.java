public enum Status {
    DRAFT, PENDING, COMPLETE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
println ("Status=" + Status.DRAFT);