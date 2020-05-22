public interface Animal {
    void fight(Animal otherAnimal);
}

public class Tiger implements Animal {
    @Override
    public void fight(Animal otherAnimal) {
        //Do Stuff
    } 
} 

public class Lion implements Animal {
    @Override
    public fight(Animal otherAnimal) {
       //Do Stuff
    }
} 

public class Dog implements Animal {
    @Override
    public fight(Animal otherAnimal) {
       //Do Stuff
    }
} 

public class TestClass{
    public static void main(String[] args){
        Animal a = factoryMethodToReturnTigerObject();
        Animal b = factoryMethodToReturnLionObject();
        a.fight(b); // This works
        b.fight(a); // This also works

        Dog dog = factoryMethodToReturnDogObject();
        Tiger tiger = factoryMethodToReturnTigerObject();
        dog.fight(tiger); // This works.
        tiger.fight(dog); // This also works.  You're good to go!

    }
}