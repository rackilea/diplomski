AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
ctx.register(IBL_Object.class);
ctx.register(CORE_Provider.class);
ctx.registerBeanDefinition("as400.hostname",
    BeanDefinitionBuilder.rootBeanDefinition(String.class)
        .addConstructorArgValue(value).getBeanDefinition());
ctx.refresh();