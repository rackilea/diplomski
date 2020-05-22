private ExecutorService executor;

@Before
public void setup() {
    executor = mock(ExecutorService.class);
    implementAsDirectExecutor(executor);
}

protected void implementAsDirectExecutor(ExecutorService executor) {
    doAnswer(new Answer<Object>() {
        public Object answer(InvocationOnMock invocation) throws Exception {
            ((Runnable) invocation.getArguments()[0]).run();
            return null;
        }
    }).when(executor).submit(any(Runnable.class));
}