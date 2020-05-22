public class CustomModule extends SimpleModule {

    public CustomModule() {
        super("custom-module", new Version(0, 1, 0, "", "", ""));
    }

    @Override
    public void setupModule(SetupContext context) {
        super.setupModule(context);
        AnnotationIntrospector ai = new CustomAnnotationIntrospector();
        context.appendAnnotationIntrospector(ai);
    }

}



@Test
public void customField() throws Exception {
    FooContainer object = new FooContainer();
    object.fooA = new Foo();
    object.fooA.bar = "asdf";
    object.fooA.biz = "fdsa";
    object.fooB = new Foo();
    object.fooB.bar = "qwer";
    object.fooB.biz = "test";

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new CustomModule());

    FilterProvider fp = new SimpleFilterProvider().addFilter("CustomFilter", new CustomFilter());
    StringWriter writer = new StringWriter();

    mapper.writer(fp).writeValue(writer, object);

    String expected = "{\"fooA\":{\"bar\":\"asdf\",\"biz\":\"fdsa\"},\"fooB\":{\"bar\":\"qwer\"}}";

    Assert.assertEquals(expected, writer.toString());
}