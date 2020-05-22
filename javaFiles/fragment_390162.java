@Configuration
    class GlobalConfiguration {
        @Bean
        @Autowired
        public Example createExample(AnotherBean anotherBean){
            final Example example = new Example();
            example.setSomeProp(anotherBean);
            return example;
        }

        @Bean
        public AnotherBean createAnotherBean(){
            return new AnotherBean();
        }
    }