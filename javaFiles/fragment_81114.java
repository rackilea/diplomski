@Test
public void testThatInNoWayTestsTheIHateToTellPeopleMyMethodNameMethod()
{
    String[] args = { "...", "...", "...", "..." };

    try
        {
        testInstance.fillParameters(args);
                fail("expected exception not thrown");
    }
        catch (Throwable ex)
        {
            assertTrue(e instanceof ArgumentException);
    }
}