@RunWith(MockitoJUnitRunner.class)
public class TestCtrlTests{

    @InjectMocks
    TestCtrl testCtrl;

    @Mock
    TestService testService;

    protected MockMvc mockMvc;

    @Before
    public void setup(){
        when(testService.getOne("jexiste")).thenReturn(new com.thalesgroup.ito.c2s.mc.portail.test.domain.Test("jexiste",1990));
        when(testService.getOne("plaf")).thenReturn(null);

        this.mockMvc = standaloneSetup(testCtrl).build();
    }

    @Test
    public void simpleGetAnswer() throws Exception{
        assertNotNull(mockMvc);
        mockMvc.perform(get("/test")).andExpect(status().isOk());
        mockMvc.perform(get("/test/jexiste")).andExpect(status().isOk());
        mockMvc.perform(get("/test/plaf")).andExpect(status().isNotFound());
    }
}