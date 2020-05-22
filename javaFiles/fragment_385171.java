class SerialPerObjectRule implements ISchedulingRule {

  private Object fObject = null;

  public SerialPerObjectRule(Object lock) {
     fObject = lock;
  }

  public boolean contains(ISchedulingRule rule) {
    return rule == this;
  }

  public boolean isConflicting(ISchedulingRule rule) {

    if (rule instanceof SerialPerObjectRule) {
      SerialPerObjectRule vup = (SerialPerObjectRule)rule;
      return fObject == vup.fObject;
    }

    return false;
  }
}