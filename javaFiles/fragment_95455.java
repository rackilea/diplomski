public class Animal {  }
public class Dog extends Animal { }
public class Cat extends Animal { }

Animal a = new Dog();
Cat c = (Cat)a; // this line produces ClassCastException as in your case