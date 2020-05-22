public class Zoo
{
   private List<Animal> animals; 

   public Zoo()
   {
      this.animals = new ArrayList<>();
   }

   //notice this method takes an Animal object as a parameter
   public void add(Animal a)
   {
      this.animals.add(a);
   }
}

public abstract class Animal
{
   private String name;
   private String type;

   public Animal(String name, String type)
   {
      this.name = name;
      this.type = type;
   }

   //all subclasses must implement this method
   public abstract void speak();
}

public class Lion extends Animal
{
   private String animalType = "Lion";

   public Lion(String name)
   {
      super(name, animalType);
   }

   public void speak()
   {
      System.out.println("ROAR");
   }
}

//....etc for the other two animals

public class TestZoo
{
   public static void main(String[] args)
   {
      Zoo myZoo  = new Zoo();
      Lion l     = new Lion("Larry");
      Elephant e = new Elephant("Eli");
      Zebra    z = new Zebra("Zayne");

      myZoo.add(l);  //<-- note that here I don't pass Animal objects to the 
      myZoo.add(e);  //    add method but subclasses of Animal
      myZoo.add(z);
   }
}