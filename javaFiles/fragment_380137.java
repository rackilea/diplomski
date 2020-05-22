MockMvc mockMvc;

@Spy
CompanyService companyServiceSpy;

@InjectMocks
CompanyController companyController;

@Before
public void setup() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(companyController).build();
}