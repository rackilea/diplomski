public class Interceptor {
@RuntimeType
public Object intercept(@SuperCall Callable<?> callable, @AllArguments Object[] allArguments, @Origin Method method, @Origin Class clazz) throws Exception {
    long startTime = System.currentTimeMillis();
    Object response;
    try {
        response = callable.call();
    } catch (Exception e) {
        System.out.println(">>>>>>>>>>>>>>>>>>>> .... Exception occurred in method call: " + methodName(clazz, method, allArguments) + " Exception = " + e);
        throw e;
    } finally {
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (elapsedTime > 3)
        System.out.println(">>>>>>>>>>>>>>>>>>>> .... Method " + methodName(clazz, method, allArguments) + " completed in " + elapsedTime + " milliseconds");
    }
    return response;
}

private String methodName(Class clazz, Method method, Object[] allArguments) {
    StringBuilder builder = new StringBuilder();
    builder.append(clazz.getName());
    builder.append(".");
    builder.append(method.getName());
    builder.append("(");
    for (int i = 0; i < method.getParameters().length; i++) {

        builder.append(method.getParameters()[i].getName());
        if (allArguments != null) {
            Object arg = allArguments[i];
            builder.append("=");
            builder.append(arg != null ? arg.toString() : "null");
        }

        if (i < method.getParameters().length - 1) {
            builder.append(", ");
        }
    }
    builder.append(")");
    return builder.toString();
  }
}