interface CaseItem<K, V> {
    boolean isDefaultCondition();

    @NotNull
    K conditionValue();

    V calculateResult();
}