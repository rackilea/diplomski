ValidatorFactory validatorFactory = Validation
    .byProvider(HibernateValidator.class)
    .configure()
    .messageInterpolator(
        new ResourceBundleMessageInterpolator(
            new MyCustomResourceBundleLocator()))
    .buildValidatorFactory();