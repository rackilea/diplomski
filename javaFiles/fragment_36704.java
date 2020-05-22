@AllArgsConstructor
final class TupleUUID
{
    @Getter
    private UUID primaryId;

    @Getter
    private UUID secondaryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TupleUUID that = (TupleUUID) o;
        return Objects.equals(primaryId, that.primaryId) 
           && Objects.equals(secondaryId, that.secondaryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryId, secondaryId);
    }
}