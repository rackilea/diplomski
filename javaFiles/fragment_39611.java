@Override
  public void didBecomeActive (UIApplication application) {
      FacebookManager.getInstance().handleDidBecomeActive(application);
  }


  @Override
  public void willTerminate (UIApplication application) {
      FacebookManager.getInstance().handleWillTerminate(application);
  }