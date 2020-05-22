@Test
public void testExample() {
    assertTrue(isValid("AX6BYU56UX6CV6BNT7NM 287430"));
    assertFalse(isValid("AX6BYU56UX6CV6BNT7NM 287431"));
}

private boolean isValid(String s) {
    String[] parts = s.split(" ");
    int[] ints = extractIntegers(parts[0]);
    int target = Integer.parseInt(parts[1]);
    return product(ints) == target;
}

private int[] extractIntegers(String s) {
    String digits = s.replaceAll("\\D+", "");
    int[] ints = new int[digits.length() / 2];
    for (int i = 0; i < digits.length(); i += 2) {
        ints[i / 2] = Integer.parseInt(digits.substring(i, i + 2));
    }
    return ints;
}

private int product(int[] ints) {
    int result = 1;
    for (int num : ints) {
        result *= num;
    }
    return result;
}