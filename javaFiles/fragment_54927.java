public class Summe extends Insurance{

 private int livingSpace;

  public Summe(int Wohnfläche) { // you can use this in future if you wnat
   // no need to call the superclass constructor 
      livingSpace = Wohnfläche;
    }

    // another constructor that overloads the first (i.e empty one)
      public Summe() {
       // no need to call the superclass constrictor 
      }

 // create a setter and a getter for the the livingSpace
 public void setLivingSpace (int livingSpace){
     this.livingSpace = livingSpace;
 }