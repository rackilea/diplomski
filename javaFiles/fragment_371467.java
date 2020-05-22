if (arg instanceof Long) {
    // Cast to Long is safe
} else if (arg instanceof Integer) {
    // Cast to Integer is safe
} else {
    // Neither Long nor Integer, for example Double
    throw new IllegalArgumentException("Only Long and Integer supported.");
}