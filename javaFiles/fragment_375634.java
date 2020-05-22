LoginPage login;

@Before
public void beforeTest() {
    login = PageFactory.initElements(driver, LoginPage.class );
}