public class MyModel extends Model implements  InitializingBean {

    @PostConstruct
    private void postConstruct() {
        //set your values here
    }

    @Override
    public void afterPropertiesSet() {
        testValues();
    }
}