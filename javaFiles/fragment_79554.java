@Component
public class MyUtility implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MyRetry myRetry = applicationContext.getBean(MyRetry.class);
        try {
            myRetry.withTemplate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}