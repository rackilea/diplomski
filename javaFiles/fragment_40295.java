Cat whiskers = new Cat();
Dog rufus = new Dog();
Dolphin flipper = new Dolphin();

method1(whiskers, rufus, flipper); // okay!
method1(rufus); // okay!
method1(); // okay!
method1(flipper,new Parakeet()); // okay!