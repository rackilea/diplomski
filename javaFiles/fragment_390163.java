@Configuration
class FirstConfiguration {

    @Bean
    public AnotherBean createAnotherBean(){
        return new AnotherBean();
    }
}

@Configuration
class SecondConfiguration {

    @Autowired
    private AnotherBean anotherBean;

    @Bean
    public Example createExample(){
        final Example example = new Example();
        example.setSomeProp(anotherBean);
        return example;
    }
 }