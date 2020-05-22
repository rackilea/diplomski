public class InjectionPointExtractor extends DefaultBindingTargetVisitor<Object, InjectionPoint> {
  private final Predicate<TypeLiteral<?>> filter;

  public InjectionPointExtractor(Predicate<TypeLiteral<?>> filter) {
    this.filter = filter;
  }

  @Override
  public InjectionPoint visit(UntargettedBinding<?> untargettedBinding) {
    return getInjectionPointForKey(untargettedBinding.getKey());
  }

  @Override
  public InjectionPoint visit(LinkedKeyBinding<?> linkedKeyBinding) {
    return getInjectionPointForKey(linkedKeyBinding.getLinkedKey());
  }

  @Override
  public InjectionPoint visit(ProviderKeyBinding<?> providerKeyBinding) {
    return getInjectionPointForKey(providerKeyBinding.getProviderKey());
  }

  private InjectionPoint getInjectionPointForKey(Key<?> key) {
    if (filter.test(key.getTypeLiteral())) {
      return InjectionPoint.forConstructorOf(key.getTypeLiteral());
    }

    return null;
  }
}