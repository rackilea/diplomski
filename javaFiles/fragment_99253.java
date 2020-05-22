public class MortgageCalculatorTest  {
    @Before
    public void before(){
        System.out.println("I am before");
    }

    @BeforeClass
    public static void beforeclass(){
        System.out.println("I am beforeclass");
    }

    @Test
    public void test(){
        System.out.println("I am a Test");
    }

    @Test
    public void test2(){
        System.out.println("I am a Failed Test");
        fail();
    }

    @AfterClass
            public static  void afterclass(){
                System.out.println("I am afterclass");

    }

    @Rule
    public ExpensiveExternalResource ExpensiveExternalResource = new ExpensiveExternalResource();

    public static class ExpensiveExternalResource implements TestRule  {


      //  public ExpensiveExternalResource(){}


        public class ExpansiveExternalResourceStatement extends Statement{

            private Statement baseStatement;

            public ExpansiveExternalResourceStatement(Statement b){
                baseStatement = b;
            }

            @Override
            public void evaluate() throws Throwable {
                try{
                    baseStatement.evaluate();
                }catch(Error e){
                    System.out.println("I take a Screenshot");
                    throw e;   
                }finally{
                    after();
                }
            }

            //Put your after code in this method!
            public void after(){
                System.out.println("I am after");
            }
        }

        public Statement apply(Statement base, Description description) {
            return new ExpansiveExternalResourceStatement(base);

        }


    }
}