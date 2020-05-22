public class TestClockRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
            BeanDefinitionRegistry registry) {
        String pattern = (String) importingClassMetadata
                .getAnnotationAttributes(TestClock.class.getName()).get("value");
        BeanDefinition beanDefinition = new RootBeanDefinition(Clock.class);
        beanDefinition.setFactoryMethodName("fixed");
        Instant instant = Instant.parse(pattern);
        ZoneId zone = TimeZone.getDefault().toZoneId();
        beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, instant);
        beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(1, zone);
        registry.registerBeanDefinition("clock", beanDefinition);
    }

}