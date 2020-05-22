public class ObserveAnimal extends ObserveBase {
    @Override
    public AnimalContract getModel() {
       return new Animal();
    }
}