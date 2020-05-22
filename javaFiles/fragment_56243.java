@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public @interface MyTestAnnotations {
}

@MyTestAnnotations
public abstract class AbstractBaseTests
{
}


@ContextConfiguration(classes = { JPAConfig.class, AOPConfiguration.class })
public class MyTest extends AbstractBaseTests {
  }