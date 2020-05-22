private List<Long> list; 

@Before
public void setUp() {
    when(mock.xxx()).thenAnswer(
            new Answer<List<Long>>() {
                @Override
                public List<Long> answer(final InvocationOnMock invocation) {
                    return list;
                }
            });
}

@Test
public void testEmptyArrayList() {
    list = new ArrayList<Long>();
    // method call
}

@Test
public void testEmptyLinkedList() {
    list = new LinkedList<Long>();
    // method call
}