public class Hooks{
    @BeforeStep
    public void beforeEachStep(){
        takeScreenshot();
    }
}