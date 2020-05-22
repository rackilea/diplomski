public class RetrofitRegistrar implements ImportBeanDefinitionRegistrar, BeanFactoryAware {

    @Setter
    private BeanFactory beanFactory;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
            BeanDefinitionRegistry registry) {
        List<String> basePackages = AutoConfigurationPackages.get(this.beanFactory);
        RetrofitComponentProvider provider = new RetrofitComponentProvider(registry);
        basePackages.stream()
                .map(provider::findCandidateComponents)
                .flatMap(Set::stream)
                .forEach(comp -> register(comp, registry));
    }

    private void register(BeanDefinition component, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.
                rootBeanDefinition(RetrofitFactoryBean.class);
        builder.addConstructorArgValue(component.getBeanClassName());
        registry.registerBeanDefinition(
                component.getBeanClassName().toLowerCase(), builder.getBeanDefinition());
    }
}