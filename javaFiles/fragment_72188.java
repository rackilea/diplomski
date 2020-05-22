interface StateTracker<S extends Enum<S>> {
  boolean isInState(S state);
}

final class MyStateTracker implements StateTracker<MyStateTracker.MyState> {
  enum MyState { S1, S2 };
  private MyState state;
  ...
  @Override
  public boolean isInState(MyState state) {
    return state == this.state;
  }
}