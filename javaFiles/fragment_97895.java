public ConsoleAppender(Layout layout) {
    this(layout, SYSTEM_OUT);
  }

  public ConsoleAppender(Layout layout, String target) {
    setLayout(layout);
    setTarget(target);
    activateOptions();
  }