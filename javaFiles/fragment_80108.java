public class MyOptionsModuleFactory {

    public static void createOptionsModule(Consumer<MyOptionsModule>... modules) {
        MyOptionsModule optionsModule = ...
        for(Consumer<MyOptionsModule> module : modules) {
            module.accept(optionsModule);
        }
    }
}