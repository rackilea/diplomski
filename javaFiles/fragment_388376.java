final Cat mom = new Cat();
final Cat child = new Cat();

child.sonOf(mom);

final Dog dad = new Dog();
child.sonOf(dad);          // "The method sonOf(Cat) in the type Cat is not applicable for the arguments (Dog)"