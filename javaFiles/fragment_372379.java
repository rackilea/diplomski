class FoodFactory {
  public Food getFood(String name) {
    switch(name) {
      case "FastFood" : return new Fastfood();
      case "Fruit" : return new Fruit();
      default: return new Food();
    }
  }