public class ProductServiceImplTest {
  @InjectMocks
  private ProductServiceImpl productServiceImpl;
  @Mock
  private ProductRepository productRepository;
  @Mock
  private Product product;

  @Before
  public void setupMock() {
    MockitoAnnotations.initMocks(this);
  }