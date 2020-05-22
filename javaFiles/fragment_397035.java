public enum RelationActiveEnum {
    Invited,
    Active,
    Suspended;

    private final int value;

    private RelationActiveEnum() {
        this.value = ordinal();
    }
}