import play.api.inject.Module;

public class SomeModule extends Module {
    @Override
    public Seq<Binding<?>> bindings(final Environment environment,
                                    final Configuration configuration)
    {
        return seq(bind(SomeObject.class).toSelf().eagerly());
    }
}