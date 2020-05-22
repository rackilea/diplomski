@Test
public void testInsertInTheMiddle() throws Exception {
    Integer[] in = {3, 5, 12, 8};
    Integer[] out = target.insertInCopy(in, 7, 2);
    assertEquals(out, new Integer[] {3, 5, 7, 12, 8});
}