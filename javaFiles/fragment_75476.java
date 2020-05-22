public static class ToStringImplementation implements Implementation {
    public static final TypeDescription SB_TYPE;
    public static final MethodDescription SB_CONSTRUCTOR_DEFAULT;
    public static final MethodDescription SB_APPEND_STRING;
    public static final MethodDescription SB_TO_STRING;

    static {
        try {
            SB_TYPE = new TypeDescription.ForLoadedType(StringBuilder.class);
            SB_CONSTRUCTOR_DEFAULT = new MethodDescription.ForLoadedConstructor(StringBuilder.class.getConstructor());
            SB_APPEND_STRING = new MethodDescription.ForLoadedMethod(StringBuilder.class.getDeclaredMethod("append", String.class));
            SB_TO_STRING = new MethodDescription.ForLoadedMethod(StringBuilder.class.getDeclaredMethod("toString"));
        }
        catch (final NoSuchMethodException | SecurityException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public InstrumentedType prepare(final InstrumentedType instrumentedType) {
        return instrumentedType;
    }

    @Override
    public ByteCodeAppender appender(final Target implementationTarget) {
        final TypeDescription thisType = implementationTarget.getInstrumentedType();

        return new ByteCodeAppender.Simple(Arrays.asList(
            // allocate the StringBuilder
            TypeCreation.of(SB_TYPE),
            // constructor doesn't return a reference to the object, so need to save a copy
            Duplication.of(SB_TYPE),
            // invoke the constructor
            MethodInvocation.invoke(SB_CONSTRUCTOR_DEFAULT),

            // opening portion of toString output
            new TextConstant(thisType.getName() + "["),
            MethodInvocation.invoke(SB_APPEND_STRING),

            // field label
            new TextConstant("name="),
            MethodInvocation.invoke(SB_APPEND_STRING),

            // field value
            // virtual call first param is always "this" reference
            MethodVariableAccess.loadThis(),
            // first param to append is the field value
            FieldAccess.forField(thisType.getDeclaredFields()
                    .filter(ElementMatchers.named("name"))
                    .getOnly()
            ).read(),
            // invoke append(String), since name is a String-type field
            MethodInvocation.invoke(SB_APPEND_STRING),

            // closing portion of toString output
            new TextConstant("]"),
            MethodInvocation.invoke(SB_APPEND_STRING),

            // call toString and return the result
            MethodInvocation.invoke(SB_TO_STRING),
            MethodReturn.of(TypeDescription.STRING)
        ));
    }
}