public <T, V> V decode(@NotNull T input, CaseItem<K, V> caseItems...) {
    if (caseItem == null) {
        return null;
    }

    for (CaseItem<K, V> caseItem : caseItems) {
        if (input.equals(caseItem.conditionValue()) {
            return caseItem.calculateResult();
        } else if (caseItem.isDefaultCondition()) {
            return caseItem.calculateResult();
        }
    }
    return null;
}