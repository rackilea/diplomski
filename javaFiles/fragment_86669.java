@RunWith(MockitoJUnitRunner.class)
public class WidgetStatusServletTest {

    @Captor private ArgumentCaptor<ArrayList<WidgetStatus>> captor;
    @Mock private DBController mockController;
    @Mock private HttpServletRequest mockRequest;
    @Mock private HttpServletResponse mockResponse;
    @Mock private Repository mockRepository;