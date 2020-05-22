public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, 
                           AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        return null != env 
               && "true".equals(env.getProperty("createWebSocket"));
    }
}