class RoadRunner implements Runnable {
   String acmeWidget;
   public RoadRunner (string acmeWidget) {
     this.acmeWidget = acmeWidget;
   }
   public void run () {
     evadeCleverPlan(acmeWidget);
   }
}

void doIt () {
  Runnable r = new RoadRunner("Fast Rocket");
  // do something with runnable
}