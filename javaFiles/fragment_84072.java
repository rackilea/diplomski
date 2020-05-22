abstract class Animal {
     abstract void act();
}

class Bird extends Animal{
      void fly(){}
      void act(){
         fly();
      }
}

class Dog extends Animal{
      void bark(){}
      void act(){
         bark();
      }
}