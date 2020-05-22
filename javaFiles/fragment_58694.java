<K, V> BinaryOperator<Map<K, List<V>>> mapMerger() {
    return (lhs, rhs) -> {
        Map<K, List<V>> result = new HashMap<>();
        lhs.forEach((key, value) -> result.computeIfAbsent(key, k -> new ArrayList<>()).addAll(value));
        rhs.forEach((key, value) -> result.computeIfAbsent(key, k -> new ArrayList<>()).addAll(value));
        return result;
    };
}