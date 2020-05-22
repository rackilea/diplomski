@SpringBootApplication
public class So49053082Application implements CommandLineRunner {

    @Bean
    String beanValueFooBar() {
        return "fooBar";
    }

    @Bean
    String beanValueBarFoo() {
        return "barFoo";
    }

    private class SomeBean {

        private String var;

        public void setVar(final String var) {
            this.var = var;
        }
    }


    @Configuration
    public class Config {
        @Bean
        public SomeBean someBean(String beanValueBarFoo) {
            SomeBean someBean = new SomeBean();
            System.out.println(beanValueBarFoo);
            someBean.setVar(beanValueBarFoo);
            return someBean;
        }
    }

    @Override
    public void run(String... args) {

    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(So49053082Application.class, args);
        context.close();
    }

}