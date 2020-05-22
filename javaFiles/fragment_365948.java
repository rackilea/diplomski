public class Dog extends Animal<Rabbit> {

    public Dog(){
        this.collectFoodBehaviour = new HuntAnimalsBehaviour<Rabbit>();
    }
}