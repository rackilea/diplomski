@Configuration
public class HelloWorldConfig1 {
    @Bean 
    public HelloWorld1 helloWorld(){
        return new HelloWorld1(); 
    }
 }