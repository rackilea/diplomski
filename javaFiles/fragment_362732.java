@Provides @Foo Repository provideFooRepository(
    RepositorySubcomponent.Builder builder,
    StoneTabletStorage stoneTabletStorage) {
  // Inject and use the builder instead, since we're passing in a required value.
  // In this example, you'd need to define a method on the builder,
  // @BindsInstance Builder storage(Storage storageImpl);
  return builder
             .storage(stoneTabletStorage)
             .build()
             .getRepository();
}

@Provides @Bar Repository provideBarRepository(
    RepositorySubcomponent.Builder builder,
    HolographicQubitStorage holographicQubitStorage) {
  return subcomponent
             .storage(holographicQubitStorage)
             .build()
             .getRepository();
}