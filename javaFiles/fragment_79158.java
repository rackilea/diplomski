public class CustomTypeMapper implements TypeMapper {

    private static final GraphQLScalarType GraphQLCustomDate = ...;

    @Override
    public GraphQLOutputType toGraphQLType(...) {
        return GraphQLCustomDate;
    }

    @Override
    public GraphQLInputType toGraphQLInputType(...) {
        return GraphQLCustomDate;
    }

    @Override
    public boolean supports(AnnotatedType type) {
        return type.getType() == Date.class; // This mapper only deals with Date
    }
}