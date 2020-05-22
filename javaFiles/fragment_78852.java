@Test
public void testLowerBoundaryOfArray() {
    BinarySearch ob = new BinarySearch();
    Comparable[] array = {10, 20, 30, 40, 50};
    int result = ob.binarySearch(array, 5);
    Assert.assertEquals("Index position should be as expected", 0, result);

}