@RunWith(MockitoJUnitRunner.class)
public class ServiceRequestTest {
    @Mock
    private RestTemplate restTemplate;

    @Mock
    public RequestConfig requestConfig;

    @Mock
    private RetryTemplate retryTemplate;

    @InjectMocks
    ServiceRequest serviceRequest;

    @Test
    public void makeGetServiceCall() throws Exception {
        //given:
        String url = "http://localhost:8080";
        ResponseEntity<String> myEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
        when(retryTemplate.execute(any(RetryCallback.class))).thenAnswer(invocation -> {
            RetryCallback retry = invocation.getArgument(0);
            return retry.doWithRetry(/*here goes RetryContext but it's ignored in ServiceRequest*/null);
        });
        when(restTemplate.exchange(eq(url), eq(HttpMethod.GET), any(HttpEntity.class), eq(String.class)))
                .thenReturn(myEntity);

        //when:
        ResponseEntity<String> response = serviceRequest.makeGetServiceCall(url);

        //then:
        assertEquals(myEntity, response);
    }
}