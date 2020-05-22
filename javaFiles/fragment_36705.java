@AllArgsConstructor
class TupleKey {

    @Getter(AccessLevel.PROTECTED)
    private TupleUUID uuid;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass())  {
            return false;
        }

        TupleKey that = (TupleKey ) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
}