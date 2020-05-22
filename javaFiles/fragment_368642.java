@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class MyControllerTest {

@Mock
private MyService myService;

@InjectMocks
private MyController MyController;

@Before
public static void init(){
    RestAssured.baseURI = "http://localhost";
    RestAssured.port = 8080;
}

@Test
void givenUrl_whenSuccessOnGetLogoutAndStuff_thenCorrect() {

    when(this.myService.getLogout(stuff)).thenReturn(something);

    given()
        .standaloneSetup(new MyController(this.myService))
        .header("principal", "admin")
        .header("authorization", "authtoken")
    .when()
        .get("/logout")
    .then()
        .statusCode(200)
        .statusLine("...")
        .body(something);
    }

}