final Object myObject = getObjectOrNull();

public Object getObjectOrNull() {
  try{
    return somethingThatCanFail();
  } catch (Fail f) {
    return null;
  }
}