public static class MyClass {

    private String name;
    private String comp;
    private double price;
    private double finalPrice; // <-- Field for final price

    [...]    

    public void updatePrice(double price) {
      this.price = price;

      double changePriceRate;
      double changePriceAmount;

      if ("Bamba".equals(this.name)) { // <-- Use equals()!
        changePriceRate = 0.15;
      } else {
        changePriceRate = 0.05;
      }

      changePriceAmount = price * changePriceRate;

      if ("Bamba".equals(this.name)) { // <-- Use equals()!
        finalPrice = price + changePriceAmount;
      } else {
        finalPrice = price - changePriceAmount;
      }
    }

    public String toString() {
      return "Name of the Snack: " + name + "\n" +
             "Name of the Company: " + comp + "\n" +
             "Price before discount: " + price + "\n" +
             "Price after discount: " + finalPrice + "\n";
    }
  }