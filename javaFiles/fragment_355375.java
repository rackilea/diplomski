@Schedule(second="*/3", minute="*", hour="*")
  public void automaticChangeOnTimer() {
        changeSomeDataA();
        changeSomeDataB();
        changeSomeDataC();
        logger.info("Automatic called the method");
  }