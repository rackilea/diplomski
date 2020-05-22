void doItAnon () {
  final String acmeWidget = "TNT";
  Runnable r = new Runnable () {
    public void run () {
      evadeCleverPlan(acmeWidget);
    }
  };
  // do something with runnable
}