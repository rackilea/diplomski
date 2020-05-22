public static void main(final String[] args) {
    final int integers[] = new int[] {3, 1, 1, 1, 13, 13, 13, 13, 13, 8, 8, 8, 8, 8, 8};

    final Map<Integer, Integer> integerFrequencies = new HashMap<>();

    // Create a map of all integers with their frequency:
    for (final int i : integers) {
        if (integerFrequencies.containsKey(i)) {
            integerFrequencies.put(i, integerFrequencies.get(i) + 1);
        }
        else {
            integerFrequencies.put(i, 1);
        }
    }

    // Sort the map entries by their value (frequency) into a list:
    final var integerFrequenciesSorted = integerFrequencies.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList());

    // Print 2nd to 4th entry:
    for (int i = 1; i < 4; i++) {
        final var integerFrequency = integerFrequenciesSorted.get(i);
        System.out.println("Value: " + integerFrequency.getKey() + ". Frequency: " +  integerFrequency.getValue());
    }
}