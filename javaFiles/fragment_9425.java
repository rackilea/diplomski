public class CacheTest {
    public static class Service {
        @Cacheable("horseCache")
        public List<String> getX(String key) {
            System.out.println("Called for " + key);
            return Arrays.asList(key + "...");
        }
    }

    @Configuration
    @EnableCaching
    public static class Config {
        @Bean
        public CacheManager cacheManager() {
            SimpleCacheManager cacheManager = new SimpleCacheManager();
            cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("horseCache")));
            return cacheManager;
        }
    }

    public static void main(String[] args) {
        // Inline application context definition to support self-contained example
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Service.class);
        GenericBeanDefinition configDefition = new GenericBeanDefinition();
        configDefition.setBeanClass(Config.class);
        context.registerBeanDefinition("bean", beanDefinition);
        context.registerBeanDefinition("config", configDefition);
        context.refresh();

        // actual example
        Service bean = context.getBean(Service.class);
        System.out.println(bean.getX("foo"));
        System.out.println(bean.getX("bar"));
        System.out.println(bean.getX("foo")); // demonstrate 2nd call is cached
    }

}