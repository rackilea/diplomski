public class SomeBean implements InitializingBean {
    private String someProperty;
    private String other;
    public void setSomeProperty(String someProperty) {
        this.someProperty = someProperty;
    }
    public void setOther(String other) {
        this.other = other;
    }
    public void init() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                // for example
                // send the two property values to some external service
            }
        });
        thread.start();
    }
    public void afterPropertiesSet() throws Exception {
        init();
    }
}