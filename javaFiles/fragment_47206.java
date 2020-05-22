public class ServiceImplTest {

    @Mock
    private ServiceDAO serviceDAO;

    @Spy
    private ServiceImpl service;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        //service = new ServiceImpl();
        service.setServiceDAO(this.serviceDAO);
    }

    @Test
    public void testGetData() {
        Mockito.doAnswer(new Answer<SqlSession>(){

            @Override
            public SqlSession answer(InvocationOnMock invocation) throws Throwable {
                return new DefaultSqlSession(null,null);
            }

        }).when(service).getSqlSession();

        Mockito.when(service.getData()).then(new Answer<List<Object>>() {

        @Override
        public List<Object> answer(InvocationOnMock invocation) throws Throwable {
            return serviceDAO.getData(new DefaultSqlSession(null,null));

        }

    });

        service.getData();

    }

}