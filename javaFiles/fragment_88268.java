public class Hook extends AbstractHook {

    AbstractHook df = new AbstractHook();

    @Before
    public void createdriver() {
        df.getdriver();
        driver.get("some url");// no need 

    }
}