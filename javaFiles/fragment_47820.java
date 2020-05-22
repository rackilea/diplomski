public static void main(String[] args) {
  Config config = parseConfig(args);
  List<Module> modules = new ArrayList<>();
  modules.add(...); // application modules

  String fooModuleName = config.get("foo_module");
  Class<? extends Module> moduleClass =
      Class.forName(fooModuleName).asSubclass(Module.class);
  modules.add(moduleClass.newInstance());

  Injector injector = Guice.createInjector(modules);
  injector.getInstance(MyApplication.class).run();
}