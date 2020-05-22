@SuppressWarnings("unused")
    @Test
    public void test() throws Exception
    {

        new Expectations()
        {
            @NonStrict
            final Source mock = null;

            {
                Source.showA(anyString);
                result = 2;
            }
        };

        assertEquals(2, Source.showA("test"));
    }