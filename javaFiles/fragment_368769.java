@RunWith(PowerMockRunner.class)
@PrepareForTest({CallHandler.class, SqlSessionFactoryBuilder.class, Resources.class})
public class CallHandlerTest {

    private static final String RESULT0 = "";

    @Test
    public void test0 () throws Exception {
        final Reader mockedReader = EasyMock.createMock(Reader.class);
        final SqlSessionFactoryBuilder mockedSqlSessionFactoryBuilder = EasyMock.createMock(SqlSessionFactoryBuilder.class);
        final SqlSessionFactory mockedSessionFactory = EasyMock.createMock(SqlSessionFactory.class);

        PowerMock.mockStatic(SqlSessionFactoryBuilder.class);
        PowerMock.mockStatic(Resources.class);

        PowerMock.expectNew(SqlSessionFactoryBuilder.class).andReturn(mockedSqlSessionFactoryBuilder);
        EasyMock.expect(Resources.getResourceAsReader("mybatis/mybatis-config.xml")).andReturn(mockedReader);
        EasyMock.expect(mockedSqlSessionFactoryBuilder.build(mockedReader)).andReturn(mockedSessionFactory);

        PowerMock.replayAll();
        assertThat(RESULT0).isEqualTo((new CallHandler()).handleRequest(new Call()));
        PowerMock.verifyAll();
    }
}