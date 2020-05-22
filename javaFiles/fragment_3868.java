@Configuration
public class LibWrapperConfiguration {

    @Bean
    public LibWrapper libWrapper(){
        return new LibWrapper();
    }
}