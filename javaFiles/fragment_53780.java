@Configuration
@ComponentScan("my.base.package")
static class OptionalConfiguration {
        @Bean
        List<Item> someString() {
            return new ArrayList<>();
        }
        @Bean
        Object foo(List<Item> obj) {
            return new Object();
        }
    }