@ExtendWith(MockitoExtension.class) // RunWith(MockitoJUnitRunner.class) for JUnit 4
public class AuthorityServiceTest {
    @InjectMocks
    private AuthorityService sut;

    @Mock RestTemplate restTemplate;

    @Test
    public void getAuthorityTest(){
        // mock rest call
        Authority auth = mock(Authority.class);
        when(restTemplate.getForObject(any(String.class), any(Class.class)).thenReturn(auth);

        Authority result = sut.getAuthority("test");

        // verify mock result was returned
        assertSame(auth, result);
        // verify call to rest template was performed
        verify(restTemplate).getForObject(
              "http://localhost:8080/authorities/test",
               Authority.class);
    }
}