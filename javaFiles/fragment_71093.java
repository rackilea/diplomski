package test;

public class Tracker extends test.parent.Tracker {

...
@Override
  public void track(final Event event) {
    //anonymous class translated into local class
    class TrackerRunnable implements Runnable {
      public void run(){
        Tracker.super.track(event);  //this works!! why??
        super.track(event); // compile error: cannot resolve
        test.parent.Tracker.track(event);  //compile error: can only reference static method
      }
    }

    Executor.execute(new TrackerRunnable()); 
  }
}