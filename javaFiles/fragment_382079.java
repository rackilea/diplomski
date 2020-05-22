@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
public class ControllerTest {
    @MockBean
    private Service service

    @Autowired
    private MockMvc mvc;

    @Test
    public void foo() {
        String somePayload = "Hello, World";
        String myParams = "foo";
        when(service.method(myParams)).thenReturn(somePayload);
        mvc.perform(get("my/url/to/test").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", is(equalTo("Hello, World"))));
    }
}