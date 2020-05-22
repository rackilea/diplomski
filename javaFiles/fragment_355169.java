public interface RequestValidator {
  void validate(HttpServletRequest req) throws ValidationError;
}

public class ValidationModule extends AbstractModule {
  @Override public void configure() {
    bindInterceptor(Matchers.any(), Matchers.annotatedWith(Validate.class), 
        new ValidateInterceptor());
  }
}

public class ValidateInterceptor implements MethodInterceptor {
  @Override public Object invoke(MethodInvocation invocation) throws Throwable {
    Method method = invocation.getMethod();
    Validate validate = method.getAnnotation(Validate.class);
    if (validate == null) {
      throw new IllegalStateException(
          "ValidateInterceptor installed on non-@Validate method");
    }
    for (Class<? extends RequestValidator> validatorClass : validate.value()) {
      RequestValidator validator = validatorClass.newInstance();
      validator.validate((HttpServletRequest) invocation.getArguments()[0]);
    }
    return invocation.proceed();
  }
}