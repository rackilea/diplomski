private final static MyClass _instance = new MyClass();

  public static MyClass getInstance() {
    return _instance;
  }

  private MyClass() {}