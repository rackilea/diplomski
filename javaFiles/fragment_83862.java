class Owner implements FlagAccess {
  private AtomicBoolean _flag;

  public boolean getFlag() {
    return _flag.get();
  }

  public void setFlag(boolean value) {
    return _flag.set(value);
  }
}

interface FlagAccess {
  public boolean getFlag();

  public void setFlag(boolean value);
}

class Worker extends Thread {
  private FlagAccess _access;
  public Worker(FlagAccess access) {
    _access = access;
  }

  public run() {
    _access.get();
    ...
    _access.set(true);
  }
}