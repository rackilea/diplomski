@PostConstruct
public void init() throws BeansException {
    Arrays.stream(signSysIds).forEach(
        i -> {
            String beanName = "/svc/curriculumScheduleService/" + i;
            AbstractBeanDefinition bean = BeanDefinitionBuilder.genericBeanDefinition(PubHessianServiceExporter.class)
                .addPropertyValue("service", StudentAppServiceFactory.curriculumScheduleServices.get(Integer.parseInt(i)))
                .addPropertyValue("serviceInterface", CurriculumScheduleService.class)
                .getBeanDefinition();
            beanFactory.registerBeanDefinition(beanName, bean);
        }
    );
}