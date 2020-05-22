public class SecurePropertyAccessor extends ReflectivePropertyAccessor {

    @Override
    public  boolean canRead(EvaluationContext context, Object target, String name) {
        boolean canRead = // Add your own logic as needed
        return canRead;
    }
}