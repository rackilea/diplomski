@RunWith(MockitoJUnitRunner.class)
public class InterfaceTest {

    @Mock
    private Service service;

    @InjectMocks
    private Employee employee;

    @Test
    public void testSuccess() throws Exception {
        Answer<Void> answer = new Answer<Void>() {
            Void answer(InvocationOnMock invocation) {
                AsyncCallback callback = invocation.getArguments()[0];
                callback.onSuccess();
                return null;
            }
        };
        doAnswer(answer).when(service).save(any(AsyncCallback.class));

        employee.save()

        // TODO: now check that the success callback does what it's supposed to do
    }
}