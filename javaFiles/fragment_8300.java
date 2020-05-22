Whatever underTest = new Whatever(); // the class with that method

@Test
public void testWith3SortedValues() {
   assertThat(underTest.minorArray(new int[] { 0, 1, 2 }), is(0));
}