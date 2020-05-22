public interface MethodAccessor
{

    Object callStaticMethod( Map context, Class targetClass, String methodName, List args )
        throws MethodFailedException;

    Object callMethod( Map context, Object target, String methodName, List args )
        throws MethodFailedException;

}