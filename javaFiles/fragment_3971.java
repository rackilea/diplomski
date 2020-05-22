public class ObserveBird extends ObserveBase {
    @Override
    public AnimalContract getModel() {
      return new Bird();
    }
}