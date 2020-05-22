public class Animal {
   private final String noise;
   protected Animal(String noise) {
      this.noise = noise;
   }

   public void makeNoise() {
      System.out.println(noise);
   }
}

public class Pig extends Animal {
    public Pig() {
       super("Oink");
    }
}