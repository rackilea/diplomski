public void testNullValue()
{
    try {
       Object o = null;
       o.toString();
       fail("Expected NullPointerException to be thrown");
    } catch (NullPointerException e) {
       assertTrue(true);
    }
}