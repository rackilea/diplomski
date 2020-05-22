@BeforeClass
public static void setUpBeforeClass() throws Exception
{
    MyTest.RULE.environment.applicationContext.stop()
    MyTest.RULE.environment.jersey().register(new JustForTestingResource())
    MyTest.RULE.environment.applicationContext.start()
}