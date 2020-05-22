@SpringBootApplication
public class AsyncConfigExample {

    @Bean
    WebMvcConfigurer configurer(){
        return new WebMvcConfigurerAdapter(){
            @Override
            public void configureAsyncSupport (AsyncSupportConfigurer configurer) {
                ThreadPoolTaskExecutor t = new ThreadPoolTaskExecutor();
                t.setCorePoolSize(10);
                t.setMaxPoolSize(100);
                t.setQueueCapacity(50);
                t.setAllowCoreThreadTimeOut(true);
                t.setKeepAliveSeconds(120);
                t.initialize();
                configurer.setTaskExecutor(t);
            }
        };
    }

}