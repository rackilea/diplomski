import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class BootstrapTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    SchedulerBootstrap schedulerBootstrap;

    @Test
    public void myTest() { 
        //Some code that berifies that init-method had been called.
        //Or start unit test in debug-mode and add a breakpoint in the 
        //init-method, you will see it being called before the test is executed.
    }
}