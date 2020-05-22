@RunWith(MockitoJUnitRunner.class) // for @Mock
class TheTest {

    @Mock
    UserService mockService;

    MockMvc mockMvc;    

    @Before
    public void setup() {        
        RegisterController registerController = new RegisterController(mockService);
        mockMvc = standaloneSetup(registerController).build();
    }

    @Test
    public void testOK() throw Exception {
        // mockService does nothing by default

        mockMvc.perform(post("/register"))
               .andExpect(view().name("/register/OK"));

        Mockito.verify(mockService).add(Matchers.any(User.class));
    }

    @Test
    public void testNotOk() {
        Mockito.when(mockService.add(Matchers.any(User.class))
               .thenThrow(new DataIntegrityViolationException()); // adjust DataIntegrityViolationException constructor args if required.

        // now mockService throw a DataIntegrityViolationException when mockService#add(User) is called

        mockMvc.perform(post("/register"))
               .andExpect(view().name("/register/NOT-OK"));

        Mockito.verify(mockService).add(Matchers.any(User.class));
    }
}