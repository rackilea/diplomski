@Test
public void searchFor7InShortListOfPrimes() {
    List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 11);
    assertEquals(3, Main.findSame(numbers.iterator(), 7, 0));  
}

@Test
public void searchFor6InShortListOfPrimes() {
    List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 11);
    assertEquals(-1, Main.findSame(numbers.iterator(), 6, 0));  
}