@EnableAsync
public class AsyncConfiguration implements AsyncConfigurer {

  @Override
  public Executor getAsyncExecutor() {
    final SubjectAwareTaskExecutor executor = new SubjectAwareTaskExecutor();
    executor.setBeanName("async-executor");
    executor.setCorePoolSize(10);
    executor.setMaxPoolSize(10);
    executor.initialize();
    return executor;
  }

  @Override
  public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
    return new SimpleAsyncUncaughtExceptionHandler();
  }
}