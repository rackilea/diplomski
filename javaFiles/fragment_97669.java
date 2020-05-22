public class Model {

    private final DoubleProperty hunger = new SimpleDoubleProperty();

    public DoubleProperty hungerProperty() {
        return hunger;
    }

    public void setHunger(double value) {
        hunger.set(value);
    }

    public double getHunger() {
        return hunger.get();
    }

}