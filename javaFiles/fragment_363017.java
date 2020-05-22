public class SecureEvaluationContext extends StandardEvaluationContext {
    @Override
    public List<PropertyAccessor> getPropertyAccessors() {
        return Arrays.asList(new SecurePropertyAccessor());
    }
}