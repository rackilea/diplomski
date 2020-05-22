public abstract class Car {

    protected final Product product;
    protected final String carType;

    public Car(Product product,String carType){
        this.product = product;
        this.carType = carType;
    }
}