class Random {
  public static void main(String[] args) {

    int tempMax = 0;

    for(int i = 0; i < 5; i++){
      int newValue = (int)((Math.random() * 91) + 10);

      if (newValue > tempMax) {
        tempMax = newValue;
      }
    }

    int max = tempMax;

    System.out.println("Max value" + max);
  }
}