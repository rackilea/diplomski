@Configuration
public class TestFactoryMethodConfig {

    @Bean(name = "stringMaker1")
    public StringMakerImpl1 stringMaker1() {
        return new StringMakerImpl1();
    }

    @Bean(name = "stringMaker2")
    public StringMakerImpl2 stringMaker2() {
        return new StringMakerImpl2();
    }

    @Bean(name = "stringPrinter")
    @Scope(value = "prototype")
    public StringPrinter stringPrinter(@Qualifier("stringMaker1") StringMakerInterface stringMaker) {
        StringPrinter instance = new StringPrinter();
        instance.setStringMaker(stringMaker);

        return instance;
    }
}