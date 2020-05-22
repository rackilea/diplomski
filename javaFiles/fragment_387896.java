//Declared in your library
public interface BreedNameProvider{
  String getBreedName();
}

public class Dog implements Pet {
 private final BreedNameProvider bnp;
 public Dog(BreedNameProvider bnp) {
   this.bnp = bnp;
 }

 public String getBreed() {
   return bnp.getBreedName();
 }
}