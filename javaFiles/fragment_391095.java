@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class UserControllerTest {

    @MockBean 
    UserService userServiceMock;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAll_IfFound_ShouldReturnFoundUsers() throws Exception {
       User first = new User();
       first.setUserId(1);
       first.setUsername("test");
       first.setPassword("test");
       first.setEmail("test@email.com");
       first.setBirthday(LocalDate.parse("1996-04-30"));

       User second = new User();
       second.setUserId(2);
       second.setUsername("test2");
       second.setPassword("test2");
       second.setEmail("test2@email.com");
       second.setBirthday(LocalDate.parse("1996-04-30"));

       Mockito.when(userServiceMock.findAll())
           .thenReturn(Arrays.asList(first, second));

       mockMvc.perform(get("/api/v1/users")).
        andExpect(status().isOk()).
        andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).
        andExpect(jsonPath("$", hasSize(2))).
        andExpect(jsonPath("$[0].userId", is(1))).
        andExpect(jsonPath("$[0].username", is("test"))).
        andExpect(jsonPath("$[0].password", is("test"))).
        andExpect(jsonPath("$[0].email", is("test@email.com"))).
        andExpect(jsonPath("$[0].email", is(LocalDate.parse("1996-04-30")))).
        andExpect(jsonPath("$[1].userId", is(2))).
        andExpect(jsonPath("$[1].username", is("test2"))).
        andExpect(jsonPath("$[1].password", is("test2"))).
        andExpect(jsonPath("$[1].email", is("test2@email.com"))).
        andExpect(jsonPath("$[1].email", is(LocalDate.parse("1996-04-30"))));

        verify(userServiceMock, times(1)).findAll();
        verifyNoMoreInteractions(userServiceMock);
    }
}