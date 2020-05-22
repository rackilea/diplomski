synchronized(lock) {
  try {
    // my code
  }
  catch (Exception e) { // generic catch to look if any exception is triggered
    System.out.printf("Caused exception: %s",e.getMessage());
  }
}