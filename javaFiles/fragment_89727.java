// Dog is a subtype of Animal
class Animal {}
class Dog extends Animal {}

// List<Dog> is a subtype of List<? extends Animal>
List<? extends Animal> a = new ArrayList<Dog>();

// all parameterized Lists are subtypes of List<?>
List<?> b = a;