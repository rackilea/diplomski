@SpringBootApplication
public class So43225913Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(So43225913Application.class, args);
        context.publishEvent("foo");
    }

    @EventListener(condition = "@bar.accept(event)")
    public void listen(Object event) {
        System.out.println("handler:" + event);
    }

    @Bean
    public Bar bar() {
        return new Bar();
    }

    public static class Bar {

        public boolean accept(Object o) {
            System.out.println("bar:" + o);
            return true;
        }
    }

}