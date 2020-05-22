@ContextConfiguration
@ContextConfiguration("classpath:spring/sample-testcontext.xml")
public class SampleTest {

    @Autowired
    private ConfigurableApplicationContext context;

    @Test
    public void foo() {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName + " --> "+  beanFactory.getBeanDefinition(beanName).getResourceDescription());
        }
    }
}