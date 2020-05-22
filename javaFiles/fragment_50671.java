class LogicProvider implements Provider<Logic> {

    private final SomeDep dep;

    @Inject
    public LogicProvider(SomeDep dep) {
      this.dep = dep;
    }

    @Override
    public Logic get() {
      return LogicCreator.create(dep);
    }

}