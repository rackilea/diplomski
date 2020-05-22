final class FixWindows extends Phase{
  private static FixWindows windows;

  private FixWindows(){
      // does nothing but preventing external classes to instantiate it
  }

  public static synchronized FixWindows getFixWindows(){
    if(windows==null){
      windows=new FixWindows();
    }
    return windows;
  }

  public void methodThatRequiresTheRemotePhase(){
    doSomeStuff(RemotePhase.getRemotePhase());
  }
}