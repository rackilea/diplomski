@ContextConfiguration(<your context location>)
@RunWith(JUnitParamsRunner.class)
public class ParameterizedTestWithSpring {

    private TestContextManager testContextManager;

    public ParametrizedTestWithSpring() throws Exception {
        this.testContextManager = new TestContextManager(getClass());
        this.testContextManager.prepareTestInstance(this);
    }

    // your test methods