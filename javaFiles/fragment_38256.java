public class MyPropNotNull implements Condition {

    public MyPropNotNull() {}

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        return env.getProperty("this.string.is.null") != null;
    }
}

@Bean
@Conditional(MyPropNotNull.class)
public MessageListener myQueue() {
    bean.setDestinationName(nullString)
}