class Animal {}
class Dog extends Animal {}    

Dog obj = new Dog();
Animal animal = new Dog();
if(obj instanceof Animal){System.out.println("true");} //true
if(animal instanceof Animal){System.out.println("true");} //true
if(animal instanceof Dog){System.out.println("true");} //true