@BindsOptionalOf @Named("Child3")
abstract BaseClass provideOptionalOfChild3();

// Then in your consumer:

private final BaseClass baseClass;

@Inject public YourConsumer(
    @Named("Child3") Optional<BaseClass> optionalChild3,
    Provider<BaseClass> defaultBaseClass) {
  baseClass =
      optionalChild3.isPresent()
      ? optionalChild3.get()
      : defaultBaseClass.get();
}