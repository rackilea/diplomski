@ContextConfiguration(classes = { GeneralTester.TestConfig.class })
@RunWith(SpringRunner.class)
public class GeneralTester {
  @TestConfiguration
  public static class TestConfig {
    @Bean
    public IProductService productService(final IProductRepository productRepository){
     return new ProductService(productRepository);
    }
    @Bean
    public IProductRepository productRepository(){
      return mock(IProductRepository.class);
    }
  }

  @Autowire
  public IProductService productService;

  @Autowire
  public IProductRepository productRepository;

  @Before
  public void setUp() {
    reset(productRepository);
  }

  @After
  public void tearDown() {
    verifyNoMoreInteractions(productRepository);
  }

  @Test
  public void doSmth() {
    //... your setup
    when(productRepository.save(any())).thenReturn("something");
    //... your call and assertions
    verify(productRepository).save(any());
  }
}