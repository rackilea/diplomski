public class MyClass {
    public void myMethod() {
        LoadProperties loadProperties = new LoadProperties();
        System.out.println(loadProperties.getProperties().getProperty("config1"));
    }
}