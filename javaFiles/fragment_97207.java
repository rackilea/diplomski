class ReflectiveFieldMatcher<T> extends BaseMatcher<Object>
{
    private final String fieldName;
    private final T expectedValue;

    ReflectiveFieldMatcher(final String fieldName, final T expectedValue)
    {
        this.fieldName = fieldName;
        this.expectedValue = expectedValue;
    }

    @Override
    public boolean matches(final Object obj)
    {
        for (final Field field : obj.getClass().getFields())
        {
            if (field.getName().equals(fieldName))
            {
                field.setAccessible(true);
                try
                {
                    Object value = field.get(obj);
                    return expectedValue.equals(value);
                }
                catch (final IllegalAccessException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
        return false;
    }

    @Override
    public void describeTo(final Description description)
    {
        description.appendText("Object with field '" + fieldName + "' with value: " + expectedValue);
    }
}