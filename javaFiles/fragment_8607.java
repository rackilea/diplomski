public class Battery extends Product {

Boolean rechargable;

public Battery(String name, Double price, Boolean rechargable) {
    super(name, price);
    this.rechargable = rechargable;
}