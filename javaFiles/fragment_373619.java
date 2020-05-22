public static String[] split(String input, char separator) {
    // Count separator (spaces) to determine array size.
    int arrSize = (int)input.chars().filter(c -> c == separator).count() + 1;
    String[] sArr = new String[arrSize];

    int i = 0;
    StringBuilder sb = new StringBuilder();
    for (char c : input.toCharArray()) { // Checks each char in string.
        if (c == separator) { // If c is sep, increase index.
            sArr[i] = sb.toString();
            sb.setLength(0); // Clears the buffer for the next word.
            i++;
        }
        else { // Else append char to current word.
            sb.append(c);
        }
    }
    sArr[i] = sb.toString(); // Add the last word (not covered in the loop).
    return sArr;
}