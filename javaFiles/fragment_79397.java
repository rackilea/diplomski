public static void assertEquals(List expected, List returned)
{
    assertEquals(expected.size(), returned.size());
    if(!expected.containsAll(returned))
    {
       fail();
    }

    for(int i = 0; i < expected.size(); i++)
    {
        assertEquals(expected.get(i),returned.get(i));
    }
}