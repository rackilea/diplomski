public static void main(String[] args) {
    String[][] ragged = { { "John", null, "Mary", "George", null }, { null, "Pete", "Rick" }, { null, null, null } };

    String[][] cleaned = new String[ragged.length][];
    for (int i = 0; i < ragged.length; i++) {
        cleaned[i] = clean(ragged[i]); // Apply clean method to each sub array.
    }

    System.out.println(Arrays.deepToString(cleaned));
}

private static String[] clean(String[] dirty) {
    int nonNullCount = 0;
    for (String string : dirty) {
        if (string != null) {
            nonNullCount++; // Count non-null Strings.
        }
    }
    String[] clean = new String[nonNullCount]; // Create array for non-null Strings.
    int cleanIndex = 0;
    for (String string : dirty) {
        if (string != null) {
            clean[cleanIndex] = string; // Insert only non-null String at index.
            cleanIndex++; // Only then update index.
        }
    }
    return clean;
}