public void setApplicationContext(ApplicationContext applicationContext) {
    if (applicationContext.containsBean("optionalBeanReference1")) {
        setOptionalBeanReference1(
            (OptionalBeanReference1)applicationContext.bean(
                "optionalBeanReference1");
    }
    ...
}