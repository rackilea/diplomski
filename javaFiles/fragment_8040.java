@Test
public void testCountOccurrences() {
  PrintStream mockSystemOut = Mockito.mock(PrintStream.class);
  System.setOut(mockSystemOut);
  new CountOccurrences().countOccurences("AABBCCD");
  Mockito.verify(mockSystemOut).print("'A':2,");
  Mockito.verify(mockSystemOut).print("'B':2,");
  Mockito.verify(mockSystemOut).print("'C':1,");
}