import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

public  class MyMockUserTestExecutionListener extends AbstractTestExecutionListener{

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        MyService myService = testContext.getApplicationContext().getBean(MyService.class);
        // ... do my init
    }
}