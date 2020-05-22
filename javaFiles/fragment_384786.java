@InterceptorBinding
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Logged
@Secured
@RequestParsed
@ResultHandled
public @interface FunctionMethod {
  // clean and empty
}