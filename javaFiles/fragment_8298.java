class BaseActivity {
    @Inject Foo foo
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        ApiComponent component = DaggerApiComponent.builder()
                .apiModule(new ApiModule())
                .build();
        injectDependencies(component)
    }

    public abstract void injectDependencies(Component component);
}

class ChildActivity extends BaseActivity {
    @Override
    public void injectDependencies(ApiComponent component) {
        component.inject(this);
    }
}

@Singleton
@Component(modules = {
        ApiModule.class
})
public interface ApiComponent {
    Api api();
    void inject(ChildActivity activity); // Injecting into child object
}