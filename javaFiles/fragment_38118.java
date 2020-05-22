@Inject
CombinedTransformer(ListInjectorWrapper injectorWrapper) {
    transformers = injectorWrapper.getList(
        FirstTransformer.class,
        SecondTransformer.class,
        ThirdTransformer.class
    );
}