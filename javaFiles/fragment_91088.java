public class SubjectAwareTaskExecutor extends ThreadPoolTaskExecutor {

  @Override
  public void execute(final Runnable aTask) {
    final Subject currentSubject = ThreadContext.getSubject();
    if (currentSubject != null) {
      super.execute(currentSubject.associateWith(aTask));
    } else {
      super.execute(aTask);
    }
  }

  ... // override the submit and submitListenable method accordingly
}