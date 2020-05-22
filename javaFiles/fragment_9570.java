@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface LibraryScope {
}

@Component(modules={LibraryModule.class})
@LibraryScope
public interface LibraryComponent {
    LibraryClass libraryClass(); //provision method for `MyManager`
}

@Module
public class LibraryModule {
    @LibraryScope
    @Provides
    public LibraryClass libraryClass() { //in your example, LibraryClass is `MyManager`
        return new LibraryClass(); //this is instantiation of `MyManager`
    }
}

public enum LibraryBootstrap {
    INSTANCE;

    private LibraryComponent libraryComponent;

    static {
        INSTANCE.libraryComponent = DaggerLibraryComponent.create();
    }

    public LibraryComponent getLibraryComponent() {
        return libraryComponent;
    }
}

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationScope {
}

@Component(dependencies={LibraryComponent.class}, modules={AdditionalAppModule.class})
@ApplicationScope
public interface ApplicationComponent extends LibraryComponent {
    AdditionalAppClass additionalAppClass();

    void inject(InjectableAppClass1 injectableAppClass1);
    void inject(InjectableAppClass2 injectableAppClass2);
    void inject(InjectableAppClass3 injectableAppClass3);
}

@Module
public class AdditionalAppModule {
    @ApplicationScope
    @Provides
    public AdditionalAppClass additionalAppClass() { //something your app shares as a dependency, and not the library
        return new AdditionalAppClass();
    }
}

public enum ApplicationBootstrap {
    INSTANCE;

    private ApplicationComponent applicationComponent;

    void setup() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                                        .libraryComponent(LibraryBootstrap.INSTANCE.getLibraryComponent())
                                        .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}