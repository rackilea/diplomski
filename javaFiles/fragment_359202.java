public class UserDetailsTest{

@InjectMocks
UserDetailsService service;

@Mock
UserHelper helperMock;

@Before
public void setUp()
{
    MockitoAnnotations.initMocks(this);
}

@Test
public void TestFindUser()
{
    UserDetailsDTO details=new UserDetailsDTO();
    detail.setid("123");
    details.setpasswd("p@wd");
    details.sename("MyName");
    details.setunit("Engg");

    List<UserDetailsDTO> userList = new ArrayList<>();
    userList.add(details);

    Mockito.when(helperMock.findUserbyID("123","p@wd")).thenReturn(userList);  

    List<UserDetailsDTO> resultUserList=serrvice.getUser("123","p@wd");
    asserThat(ud,is(notNullValue()));
    assertThat("Size", userList.size(), equalTo(resultUserList.size());
    assertEquals("Details",details, equalTo(resultUserList.get(0)));
}