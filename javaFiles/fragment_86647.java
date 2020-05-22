@Configuration
    public class Config {

        @Bean
        public<T> Class<T> tClass(){
            return (some class to be returned);// you need to generify or pass some type of class which you want 
        }

    }


    //Here is injecting with no problems
        @Component
        public class Test<T> {

            private Class<T> tClass;

            @Autowired
            public Test(Class<T> tClass) {
                this.tClass = tClass;
            }
        }