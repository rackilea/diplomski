public class Bean {

    private Instance<Car> carInstances;

    @Inject
    Bean(@Any Instance<Car> carInstances){
        this.carInstances = carInstances;
    }

    public void use(){
        Car newCar = carInstances.get();
        // Do stuff with car ...
    }

}