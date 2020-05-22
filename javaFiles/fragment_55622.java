public class MyMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(A.class, B.class)
                .field("classInA", "classInB")
                .register();

        factory.classMap(ClassInA.class, ClassInB.class)
                .byDefault
                .register();
    }
}