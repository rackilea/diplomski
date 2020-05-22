@Provides
Bar provideBar(MembersInjector<Bar> injector) {
  Bar bar = new Bar();
  injector.inject(bar);
  return bar;
}