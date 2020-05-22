public <T extends Comparable<T>> TRange<T> valueToRange(T val, List<T> rangeValues) {
    List<T> vals = rangeValues;
    if (vals == null) {
        vals = (List<T>) (List<?>) (this.values != null ? this.values : this.defaultValues);
    }
    return valueToRange(val, vals, this.range);
}