@Test
public void testDoubleGeneric()
{
    commitEdit(3.1514D);
}

private <T> void commitEdit(final T value)
{
    if (!(value instanceof Double))
    {
        throw new IllegalArgumentException();
    }
}