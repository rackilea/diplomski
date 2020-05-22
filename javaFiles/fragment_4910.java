@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private long launchTime;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        launchTime = System.currentTimeMillis();
    }

    public long getLaunchTime() {
        return launchTime;
    }
}