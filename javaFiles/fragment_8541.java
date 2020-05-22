public class Human<A extends Animal> {

   private A favoriteAnimal;

   public A getFavoriteAnimal(){
      return favoriteAnimal;
   }
}

...
public static void main(String[] args) {

   Human<Seymour> fry = new Human<Seymour>();
   // etc.
   boolean petrified = fry.getFavoriteAnimal().isPetrifiedInDiamondium();
}