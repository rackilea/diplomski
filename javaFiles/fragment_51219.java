public class Component
{
    private int bandwidthWithHeader;

    public int getBandwidthWithHeader()
    {
        return bandwidthWithHeader;
    }

    public void setBandwidthWithHeader(final int newValue)
    {
        bandwidthWithHeader = newValue;
    }
}

public class ComponentTest
{
    private final ComponentComparator componentComparator = new ComponentComparator();

    @Test
    public void negative1()
    {
        Component two = new Component();

        try
        {
            componentComparator.compare(null, two);
            fail("Expected exception was not thrown");
        }
        catch(NullPointerException exception)
        {
            // The NullPointerException is the expected result.
            assertTrue(true);
        }
    }

    @Test
    public void negative2()
    {
        Component one = new Component();

        try
        {
            componentComparator.compare(one, null);
            fail("Expected exception was not thrown");
        }
        catch(NullPointerException exception)
        {
            // The NullPointerException is the expected result.
            assertTrue(true);
        }
    }

    @Test
    public void negative3()
    {
        try
        {
            componentComparator.compare(null, null);
            fail("Expected exception was not thrown");
        }
        catch(NullPointerException exception)
        {
            // The NullPointerException is the expected result.
            assertTrue(true);
        }
    }

    @Test
    public void positive1()
    {
        Component one = new Component();
        Component two = new Component();

        // test one < two
        one.setBandwidthWithHeader(7);
        two.setBandwidthWithHeader(16);

        assertEquals(-1, componentComparator.compare(one, two);

        // test two < one
        one.setBandwidthWithHeader(17);
        two.setBandwidthWithHeader(16);

        assertEquals(1, componentComparator.compare(one, two);

        // test two == one
        one.setBandwidthWithHeader(25);
        two.setBandwidthWithHeader(25);

        assertEquals(0, componentComparator.compare(one, two);
    }
}