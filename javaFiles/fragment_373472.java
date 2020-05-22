@Module()
public class ModuleA {
    @Provides @Named("ValueA") String provideValueA() {
        return "This is ValueA";
    }
}

@Module(
    includes = ModuleA.class
)
public class ModuleB {
    // ValueA comes from ModuleA
    @Provides @Named("ValueB") String provideValueB(@Named("ValueA") String valueA) {
        return valueA + " and ValueB";
    }
}