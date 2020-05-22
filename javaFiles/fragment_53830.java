public class NodeInterceptor {

  @RuntimeType
  public static Object intercept(@Pipe Function<Node, Object> pipe,
                                 @FieldValue("node") Node proxy) throws Exception {
      return proxy != null
        ? pipe.apply(proxy);
        : null;
  }
}