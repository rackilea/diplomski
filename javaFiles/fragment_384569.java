// @Mock //removed this annotation
   RepositoryInterface repositoryInterface;


@Before
   public void setUp() {
     repositoryInterface = mock(RepositoryInterface.class)
     ImplementationClass = new ImplementationClass(repositoryInterface);
     MockitoAnnotations.initMocks( this );
}