@Mock
private LoginService loginService;
@InjectMocks
private LoginController loginController;
@Before
public void init(){
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders
            .standaloneSetup(loginController)
            .build();
}