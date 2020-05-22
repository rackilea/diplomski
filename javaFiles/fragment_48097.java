class Test {
  int x;
  static Test globalInstance = new Test();

  public static doSthStatically( Test paramInstance ) {
    paramInstance.x = 0; //a specific instance to Test is passed as a parameter
    globalInstance.x = 0; //globalInstance is a static reference to a specific instance of Test

    Test localInstance = new Test();
    localInstance.x = 0; //a specific local instance is used
  }
}