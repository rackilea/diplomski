public static boolean fieldMatches(String line, int fieldIndex, String other) {
    int currentField = 0;
    int startIndex = 0;
    while (currentField < fieldIndex) {
        startIndex = line.indexOf('|', startIndex);

        // not enough fields
        if (startIndex < 0)
            return false;

        startIndex++;
        currentField++;
    }

    int start = startIndex;
    int end = line.indexOf('|', startIndex);
    if (end == -1) {
        end = line.length();
    }
    int fieldLength = end - start;

    // make sure both strings have the same length
    if (fieldLength != other.length())
        return false;

    // regionMatches does not allocate objects
    return line.regionMatches(start, other, 0, fieldLength);
}

public static void main(String[] args) {
    String line = "Config|true"; // from BufferedReader
    System.out.println(fieldMatches(line, 0, "Config"));
    System.out.println(fieldMatches(line, 1, "true"));
    System.out.println(fieldMatches(line, 1, "foobar"));
    System.out.println(fieldMatches(line, 2, "thereisnofield"));
}