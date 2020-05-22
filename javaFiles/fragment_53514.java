public class FooAdapter {

    private final JavaBeanStringProperty name;

    public FooAdapter(Foo foo) {
        try {
            name = JavaBeanStringPropertyBuilder.create().bean(foo).name("name").build();
        } catch (NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }
    }

    public final void setName(String name) {
        this.name.set(name);
    }

    public final String getName() {
        return name.get();
    }

    public final StringProperty nameProperty() {
        return name;
    }

}