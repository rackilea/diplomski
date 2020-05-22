class Food {
  public void servesFood(){
    System.out.println("I'm serving Food");
  }
}

class FastFood extends Food {
  @Override
  public void servesFood(){
    System.out.println("I'm serving Fastfood");
  }
  ... similar for Fruit