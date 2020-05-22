@Test
public void doSomething(@Mocked ToBeChanged mock)
{
    new NonStrictExpectations() {{ ToBeChanged.changeMyBehaviour(); result = true; }};

    boolean res = new ToBeTested().doSomething();

    assertTrue(res);
}