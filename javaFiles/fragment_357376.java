@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { TestController.class,
                                   RepoFactory4Test.class } )
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class,
                           DirtiesContextTestExecutionListener.class,
                           TransactionDbUnitTestExecutionListener.class } )
@DatabaseSetup( "classpath:FillTestData.xml" )
@DatabaseTearDown( "classpath:DbClean.xml" )
public class ControllerWithRepositoryTest
{
    @Autowired
    private TestController myClassUnderTest;

    @Test
    public void test()
    {
        Iterable<EUser> list = myClassUnderTest.findAll();

        if ( list == null || !list.iterator().hasNext() )
        {
            Assert.fail( "No users found" );
        }
        else
        {
            for ( EUser eUser : list )
            {
                System.out.println( "Found user: " + eUser );
            }
        }
    }

    @Component
    static class TestController
    {
        @Autowired
        private UserRepository myUserRepo;

        /**
         * @return
         */
        public Iterable<EUser> findAll()
        {
            return myUserRepo.findAll();
        }
    }
}