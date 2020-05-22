@Mock
private List<String> mockedList;

@Before
public void init() {
    MockitoAnnotations.initMocks(this);

    List<String> realList = new ArrayList<>();
    doAnswer(new Answer<String>() {
        @Override
        public String answer(InvocationOnMock invocation) throws Throwable {
            realList.add(invocation.getArgumentAt(0, String.class));
            return null;
        }

    }).when(mockedList).add(any());

    when(mockedList.iterator()).thenAnswer(new Answer<Iterator<String>>() {

        @Override
        public Iterator<String> answer(InvocationOnMock invocation) throws Throwable {
            return realList.iterator();
        }
    });

    mockedList.add("bar");
    mockedList.add("baz");
}

@Test
public void iterateOverMockedList() {
    for (String each : mockedList) {
        System.out.println(each);
    }
}