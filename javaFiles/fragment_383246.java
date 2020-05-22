@Test
public void positiveCase1()
{
    // Fill your input parameters with data that you know must work:
    List<Protocoll> protocolList=...
    testedMethod(protocolList);
}

@Test
public void positiveCase2()
{
    ...
}

@Test(expected=AssertException.class)
public void negativeCase1()
{
    // Fill your input parameters with data that you know must NOT work:
    List<Protocoll> protocolList=...
    testedMethod(protocolList);
}

@Test(expected=AssertException.class)
public void negativeCase2()
{
    ...
}