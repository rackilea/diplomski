@Before
public void setUp() {
    UserSessionPool mockConnectionPool = Mockito.mock(UserSessionPool.class);
}

@Test
public void testName() throws Exception {
    //given
    PowerMockito.mockStatic(UserSessionPool.class);
    BDDMockito.given(UserSessionPool.getInstance()(...)).willReturn(mockConnectionPool);
    Mockito.when(mockConnectionPool.getSessionUser(Mockito.anylong())).thenReturn(something);


    //then
    PowerMockito.verifyStatic();

}