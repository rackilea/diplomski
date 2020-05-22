@Autowired
private CheckUserServiceImpl checkUserService;
private HrService hrServiceBad;
private ClientResponseFailure clientResponseFailure;
private ClientResponseImpl response = new ClientResponseImpl();

@Before
public void init() {
    hrServiceBad = Mockito.mock(HrService.class);
    checkUserService.setHrService(hrServiceBad);
}

@Test(expected = EsbVerificationError.class)
public void testUserValidInEsbWith412Fault() throws EsbOffLineException, EsbVerificationError {
    // precondition failed
    response.setStatus(412);
    clientResponseFailure = new ClientResponseFailure(response); // add this.
    Mockito.doThrow(clientResponseFailure).when(hrServiceBad).verifyIdentity("412", "aaa", "aaa");
    checkUserService.setHrService(hrServiceBad);
    checkUserService.verifyUserInEsb("412", "aaa", "aaa");
}