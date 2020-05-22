public abstract class ObservableAnswer implements Answer {
  private Listener[] listeners; // to keep it very simple...

  public ObservableAnswer(Listener...listeners) {
    this.listeners = listeners;
  }

  @Override
  public Object answer(InvocationOnMock invocation) {
    Object answer = observedAnswer(invocation);
    for (Listener listener:listeners) {
       listener.send(answer);
    }
    return answer;
  }

  // we'll have to implement this method now
  public abstract Object observedAnswer(InvocationOnMock invocation);
}