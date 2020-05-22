abstract class Animal{
    public abstract Product produce();
}

class Chicken extends Animal{

    public Product produce(){
         return new Egg();
    }
}