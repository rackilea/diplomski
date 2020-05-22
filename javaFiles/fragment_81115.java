@Test
public void testTheIHateToTellPeopleMyMethodNameMethod()
{
    String[] args = { "...", "...", "...", "..." };

    testInstance.IHateToTellPeopleMyMethodName(args);

          verify(mockLogger).error(
                eq(EXPECTED_MESSAGE_TEXT),
                    any(ArgumentException.class));
}