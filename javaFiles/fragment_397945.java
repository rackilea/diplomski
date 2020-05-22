@SuppressWarnings({"rawtypes", "unchecked"})
public class Unchecked {
    public static interface UncheckedDefinitions{
        InputStream openStream();
        String readLine();
            ...
    }

  private static Class proxyClass = Proxy.getProxyClass(Unchecked.class.getClassLoader(), UncheckedDefinitions.class);

    public static UncheckedDefinitions unchecked(final Object target){
        try{
            return (UncheckedDefinitions) proxyClass.getConstructor(InvocationHandler.class).newInstance(new InvocationHandler(){
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (target instanceof Class){
                        return MethodUtils.invokeExactStaticMethod((Class) target, method.getName(), args);
                    }

                  return MethodUtils.invokeExactMethod(target, method.getName(), args);
                }
            });
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}