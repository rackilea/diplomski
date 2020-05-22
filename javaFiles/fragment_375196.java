public void buidDog() {
   Dog newDog = new Dog();
   Tail newTail = new Tail();
   newDog.tail = newTail;
   newTail.dog = newDog;
}