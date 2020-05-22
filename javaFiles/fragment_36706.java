@AllArgsConstructor
final class ObjectKey extends TupleKey {
    public UUID getSourceId() {
        return getUuid().getPrimaryId();
    }

    public UUID getTargetId() {
        return getUuid().getSecondaryId();
    }
}