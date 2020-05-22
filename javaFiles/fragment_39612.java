@Override
  public void didBecomeActive (UIApplication application) {
      super.didBecomeActive(application);
      FacebookManager.getInstance().handleDidBecomeActive(application);
  }


  @Override
  public void willTerminate (UIApplication application) {
      super.willTerminate(application);
      FacebookManager.getInstance().handleWillTerminate(application);
  }