package de.scrum_master.aspect;

public aspect ErrorHandler {
  String around() : execution(String *(..)) {
    try {
      return proceed();
    } catch (Exception e) {
      System.out.println("Exception handled: " + e);
      return "dummy";
    }
  }
}