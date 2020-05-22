@Test
public void testCountOccurrences() {
  Map<Character, Integer> expected = new HashMap<Character, Integer>();
  expected.put("A", 2);
  expected.put("B", 2);
  expected.put("C", 1);
  assertEquals(
    expected,
    new CountOccurrences().countOccurences("AABBCCD");
  );
}