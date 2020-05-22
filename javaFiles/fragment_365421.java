class Options{

  boolean replay = false;
  boolean replayAll = false;

  // getters and setters

  // other methods holding flag combinations, like:
  public boolean replayNone(){
   return !replay && ! replayAll;
  }
}