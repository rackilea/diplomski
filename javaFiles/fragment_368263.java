public class LinuxCondition implements Condition{

  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    return context.getEnvironment().getProperty("os.name").contains("Linux");  }
}