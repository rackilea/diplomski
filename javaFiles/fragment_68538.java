/**
 * Test of getPositiveNumbers method
 */
@Test
public void testGetPositiveNumbers() {
    System.out.println("getPositiveNumbers");
    int[] numbers = {2, 3, -9, 4, -29, 50, -34, -32};
    int[] expResult = {2,3,4,50};
    int[] result = ToDelete.getPositiveNumbers(numbers);
    assertArrayEquals(expResult, result);
}