public class TestClassUnitTest {
    TestClass sut;
    private LinkedList testQueue = new LinkedList();
    private SynchronousQueue<SomeResultCode> resultQueueMock = mock(SynchronousQueue.class);
    private HelperClass helperClassMock = mock(HelperClass.class);

    @Before
    public void setup() {
        sut = new TestClass();
        injectField(sut, "resultQueue", resultQueueMock);
        injectField(sut, "helperClassFieldName", helperClassMock);
    }

    public void injectField(Object testObject, String fieldName, T mockToInject) {
        // some code using reflection to inject the mock object into the test object
    }

    @Test
    public void testMethodWithNetworkCallWithDoAnswer() {
        doAnswer(new Answer(){
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ((GenericCallback)invocation.getArguments()[0]).onSuccess(new JSONObject());
                return null;
            }
        }).when(helperClassMock).makeNetworkCall(any(GenericCallback.class));
        mockQueue();
        SomeResultCode result = sut.methodWithNetworkCall();
        Assert.assertEquals(SomeResultCode.SUCCESS, result);
    }

    private void mockQueue() {
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                testQueue.push(((SchedulableJob.Result)invocation.getArguments()[0]));
                return true;
            }
        }).when(resultQueueMock).offer(any());

        try {
            doAnswer(new Answer() {
                @Override
                    public Object answer(InvocationOnMock invocation) throws Throwable {
                    if (testQueue.size() > 0) {
                        return testQueue.pop();
                    } else {
                        return null;
                    }
                }
            }).when(resultQueueMock).poll(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {

        }
    }
}