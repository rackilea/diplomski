@ContextConfiguration(locations = {"classpath:/application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DeviceCatalogueControllerTest {


    @InjectMocks
    private DeviceCatalogueController controller;

    @InjectMocks
    protected SessionHelper sessionHelper;

    @Mock
    private MessageSource messageSource;

    @Mock
    protected CataloqueService cataloqueService;

    @Autowired
    protected ApplicationDao applicationDao;

    @Before
    public void setUpTest() {
        MockitoAnnotations.initMocks(this);
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void testInitFormGet() throws Exception {

        System.out.println("SessionHelper sessionHelper --> " + sessionHelper);

        //controller.initFormGet(searchForm, localeParam, request, response, model, locale)
        controller.initFormGet(null, DEFAULT_LOCALE, request, response, null, new Locale(DEFAULT_LOCALE));
    }
}