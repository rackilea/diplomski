public class B {

    private ConfigProperties properties;

    public B() {
        BeanUtil.getBean(ConfigProperties.class); // This will initialize properties variable properly.
    }

    public void printSomething() {
       System.println(properties.getHostname());
       System.println(properties.getPort());
    }

}