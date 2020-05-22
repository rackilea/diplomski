@AllArgsConstructor
final class AnimalKey extends TupleKey {
    public UUID getCatId() {
        return getUuid().getPrimaryId();
    }

    public UUID getDogId() {
        return getUuid().getSecondaryId();
    }
}