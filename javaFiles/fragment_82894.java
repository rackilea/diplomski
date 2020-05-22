public class DetectionListener implements DetectionEventListener {
  public DetectionListener() {
    super();
  }

  public void motionIsDetected(DetectionEvent e) {
    System.out.println("Motion Detected Awareness Listener test driver activated " +    
       e.getCameraId());
   }

  public void motionAtLocation (MotionLocation  e) {
    System.out.println("Test driver Motion location = " + e.getX() + ", " + e.getY());
  }

  public void motionHasCeased(DetectionEvent  e) {
    System.out.println("Motion Ceased Listener test driver activated from " + 
      e.getCameraId());
  }

  public void eventVideoNowComplete (String eventId) {
    System.out.println("Event Video test driver activated");
  }
}