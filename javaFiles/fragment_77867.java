@Test
public void encodingNumbersMustBeUnique() {
    Set<Integer> numbers = new HashSet<Integer>();
    for (EncodingsEnum e : EncodingsEnum.values()) {
        assertFalse(numbers.contains(e.getEncodingNumber()));
        numbers.add(e.getEncodingNumber());
    }
}