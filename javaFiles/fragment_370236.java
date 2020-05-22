public abstract class TestClass {
    @BeforeClass
    public void beforeClass(){
        setup();
    }

    protected void abstract setup();

    @AfterClass
    public void afterClass(){
       tearDown();
   }

    protected void abstract tearDown();
}