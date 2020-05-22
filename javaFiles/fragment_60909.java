class Whatever {

  private static int counter = getCountInit();

  public static resetCounter() {
    counter = getCountInit();
  }

  private static getCountInit() {
    return 0; // or some fancy computation
  }

}