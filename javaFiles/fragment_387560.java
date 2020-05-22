aspect LogAllMethods {
  Log log = new Log(); // pseudocode -- replace with whatever logging mechanism you like

  before(): call(public * com.mycompany.*.*(..)) {
    log.log("Entered method: " + thisJoinPoint);
  }

  after(): call(public * com.mycomapny.*.*(..)) { 
    log.log("Leaving method: " + thisJoinPoint);
  }
}