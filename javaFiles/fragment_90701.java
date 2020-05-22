class RetrofitComponentProvider extends ClassPathScanningCandidateComponentProvider {

    @Getter
    private BeanDefinitionRegistry registry;

    public RetrofitComponentProvider(BeanDefinitionRegistry registry) {
        super(false);

        Assert.notNull(registry, "BeanDefinitionRegistry must not be null!");
        this.registry = registry;

        addIncludeFilter(new AnnotationTypeFilter(Retrofit.class, true, true));
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return true;
    }
}