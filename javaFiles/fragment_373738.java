@Configuration
public class ApplicationConfiguration {

    /**
     * Define bean-one, which can be referenced in Java config or XML config.
     * @return
     */
    @Bean(name = "bean-one")
    public String whoAmI(){
        return "bean 1.";
    }

    /**
     * Create a bean with the who am I from the XMl config.
     * @param whoAmI
     * @return
     */
    @Bean(name = "xml-message")
    public String xmlMessage(@Qualifier("bean-two") String whoAmI){
        return "I am " + whoAmI;  // I am bean 2
    }

    /**
     * Define the bean with the who am I from the Java config
     * @param whoAmI
     * @return
     */
    @Bean(name="java-message")
    public String javaMessage(@Qualifier("bean-one") String whoAmI){
        return "I am " + whoAmI; // I am bean 1
    }
}