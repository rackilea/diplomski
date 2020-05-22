@ConfigurationProperties(prefix="my.config")
public class MyConfigConfigurationProperties {
    MyCustomProperty name = new MyCustomProperty("name", "good", 100);
    MyCustomProperty fame = new MyCustomProperty("fame", "good", 100);

    // getter and Setters

    // You can also embed the class MyCustomProperty here as a static class. 
    // For details/example look at the linked SpringBoot Documentation
}