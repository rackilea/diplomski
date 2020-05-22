@Subcomponent(modules = {RepositoryModule.class, StoneTabletStorageModule.class})
public interface FooSubcomponent {
  Repository getFooRepository();
}

@Subcomponent(modules = {RepositoryModule.class, HolographicQubitStorageModule.class})
public interface BarSubcomponent {
  Repository getBarRepository();
}