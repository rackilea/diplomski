@RunWith(MockitoJUnitRunner.class)
public class LoadDataTest {

    @InjectMocks
    private LoadData loadData;

    @Spy
    private ThreadPoolTaskExecutor spyTaskExecutor = new ThreadPoolTaskExecutor();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        spyTaskExecutor.setCorePoolSize(1);
        spyTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        spyTaskExecutor.initialize();
    }

    @Test
    public void testGetData_shouldThrowInterruptedException () {
        setupSpyTaskExecutorForException(new InterruptedException("junit"));

        SomeData result = loadData.getData(101L);
        //verify here that InterruptedException processing was performed
    }

    private void setupSpyTaskExecutorForException(Exception e) {
        Mockito.doAnswer(new Answer<Future<?>>() {
            public Future<?> answer(InvocationOnMock invocation) throws Throwable {
                Future<?> future = Mockito.mock(FutureTask.class);
                when(future.get()).thenThrow(e);
                return future;
            }
        }).when(spyTaskExecutor).submit(Matchers.<Callable<?>>any());
    }
}