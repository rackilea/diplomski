verify(myManager).method1(doubleThat(new ArgumentMatcher<Double>() 
{
    @Override 
    public boolean matches(final Object actual)
    {
        return Math.abs(expected - (Double) actual) <= delta;
    }
}));