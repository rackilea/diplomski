public class FixesModule extends SimpleModule {

    public FixesModule() {
        super();
        addDeserializer(String.class, new CustomStringDeserializer());
    }
}