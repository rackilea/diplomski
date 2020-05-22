@Test(expected = IndexOutOfBoundsException.class)
public void testIndexOutOfBoundsException() {

    ArrayList emptyList = new ArrayList();
    Object o = emptyList.get(0);

}