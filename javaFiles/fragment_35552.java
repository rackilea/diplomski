public class CustomObjectScalarMapper extends ObjectScalarMapper {
    private static final String OBJECT_SCALAR_NAME = "ObjectScalar";

    @Override
    protected String getTypeName(AnnotatedType type, BuildContext buildContext) {
        return OBJECT_SCALAR_NAME;
    }

    @Override
    protected String getInputTypeName(AnnotatedType type, BuildContext buildContext) {
        return OBJECT_SCALAR_NAME;
    }
}