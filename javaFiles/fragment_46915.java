@Test
public void testSomething() {
    GenericApplicationContext context = SpringPlugin.applicationContext;
    GenericBeanDefinition definition = new GenericBeanDefinition();
    definition.setBeanClass(TestPrinter.class);
    definition.setAutowireCandidate(true);
    context.registerBeanDefinition("printer", definition);

    MyJob job = new MyJob();
    job.doJob();
}