class SomethingResult {
  ClassA client;
  ClassB conn;
  SomethingResult(ClassA client, ClassB conn) {
    this.client = client;
    this.conn = conn;
  }
  // Getters
}

public SomethingResult doSomething(String aString, String bString, String cString, String dString) {
    // Create client and conn and execute any other logic
    return new SomethingResult(client, conn);
}