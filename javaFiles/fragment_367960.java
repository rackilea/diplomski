public class PostgreSQLIlikeFunction implements SQLFunction {

    @Override
    public Type getReturnType(Type columnType, Mapping mapping)
        throws QueryException {
        return new BooleanType();
    }

    @SuppressWarnings("unchecked")
    @Override
    public String render(Type firstArgumentType, List args, SessionFactoryImplementor factory) throws QueryException {
        if (args.size() != 2) {
            throw new IllegalArgumentException(
                "The function must be passed 2 arguments");
        }

        String str1 = (String) args.get(0);
        String str2 = (String) args.get(1);

        return str1 + " ilike " + str2;
    }

    @Override
    public boolean hasArguments() {
        return true;
    }

    @Override
    public boolean hasParenthesesIfNoArguments() {
        return false;
    }

}