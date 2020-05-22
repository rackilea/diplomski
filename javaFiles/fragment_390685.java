public class MyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return Arrays.stream(context.getEnvironment().getProperty("values.in.property.file").split(","))
                .anyMatch(propValue -> propValue.equals(System.getProperty("whatever")));
    }
}