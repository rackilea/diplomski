public class Dog implements Pet {
 private final BreedNameProvider bnp;
 public Dog(BreedNameProvider bnp) {
   this.bnp = bnp;
 }

 public String getBreed() {
   return bnp.poodle();
 }
}