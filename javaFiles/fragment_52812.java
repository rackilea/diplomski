@Test public void
itAddsOne()
{
    int numberToAddTo = 1;
    int result = new Adder().addOneTo(numberToAddTo);
    assertEquals("One plus one is two", 2, result);
}

@Test(expected="NullPointerException.class") public void
itChokesOnNulls()
{
   new Adder().addOneTo((Integer)null);
}

@Test public void
itDoesntOverflow()
{
    int result = new Adder().addOneTo(Integer.MAX_VALUE);
    // do whatever here to make sure it worked correctly
}