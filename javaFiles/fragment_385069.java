@Configuration
public class MvcConfig extends HateoasAwareSpringDataWebConfiguration {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(renamingProcessor());
    }

    @Bean
    protected RenamingProcessor renamingProcessor() {
        return new RenamingProcessor(true);
    }
}