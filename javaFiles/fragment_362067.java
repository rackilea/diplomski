public class Extending {

    // Keep an additional copy (ugly and probably unsafe).
    final dependendcy dependendcy;
    final Base base;

    public Extending(final Class<? extends Base> cls,
                     final ISomeDependencySubtype dependendcy) throws Exception {
        this.dependency = dependency;
        this.base = cls.getConstructor(ISomeDependency.class).newInstance(dependency);
    }
}