private String exceptionHappened = "";

private void method1() {
    method(2);
    // Here I can check value of exceptionHappened
}

//... methods 2-4

private void method5() {
    try {
      // ...
    } catch (Exception e) {
      this.exceptionHappened = "In method 5";
    }
}