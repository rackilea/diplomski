public abstract  class Car {
public abstract void printMe();
}
public class Audi {
@Override
public void printMe() {
Utility.printString("Audi");
}