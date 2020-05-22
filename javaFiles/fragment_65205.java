public class CustomTestRunner extends AbstractTestRunner {

    @Override
    public abstract void prepareTest(final Object test) {
     // have your way with the test object
    }
}

public abstract class AbstractTestRunner extends BlockJUnit4ClassRunner {

    @Override
    public Object createTest() throws Exception {
         Object test = super.createTest();
         prepareTest(test);
         return test;
    }

    public abstract void prepareTest(final Object test);
}