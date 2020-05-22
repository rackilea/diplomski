@Configuration
class GlobalConfiguration {
    @Bean
    public Example createExample(){
        final Example example = new Example();
        example.setSomeProp(createAnotherBean());
        return example;
    }

    @Bean
    public AnotherBean createAnotherBean(){
        return new AnotherBean();
    }
}