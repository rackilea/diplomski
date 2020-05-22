<T> boolean contextualEquals(T entryValue, T validatorValue, T contextValue, MatchinMode mode) {
    if (mode == SPECIFIC) {
        return Objects.equals(entryValue, validatorValue);
    }
    return Objects.equals(entryValue, contextValue);
}