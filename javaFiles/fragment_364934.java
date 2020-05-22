public class MyInterceptor<T> {

  final T proxyClient;

  @RuntimeType
  public Object intercept(@Origin Method method, 
                          @AllArguments Object[] args) throws Throwable {
    try {
      return method.invoke(proxyClient, args);
    } finally {
      // do your completion logic here
    }
  }
}