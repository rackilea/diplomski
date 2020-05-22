@Component
public class BeanScopeValidator implements BeanPostProcessor {

  private final ConfigurableListableBeanFactory configurableBeanFactory;

  @Autowired
  public BeanScopeValidator(ConfigurableListableBeanFactory configurableBeanFactory) {
    this.configurableBeanFactory = configurableBeanFactory;
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    String beanScope = configurableBeanFactory.getBeanDefinition(beanName).getScope();
    String[] dependenciesForBean = configurableBeanFactory.getDependenciesForBean(beanName);

    for (String dependencyBeanName : dependenciesForBean) {
      String dependencyBeanScope = configurableBeanFactory.getBeanDefinition(dependencyBeanName).getScope();

      // TODO: Check if the scopes are compatible and throw an exception
    }

    return bean;
  }
}