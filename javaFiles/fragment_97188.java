public class Car {
    private AutoMake make;
    private String model;
    public Car() {
    }
    public Car(AutoMake make, String model) {
        super();
        this.make = make;
        this.model = model;
    }
    /**
     * @return the make
     */
    public AutoMake getMake() {
        return make;
    }
    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }
    /**
     * @param make the make to set
     */
    public void setMake(AutoMake make) {
        this.make = make;
    }
    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }
}