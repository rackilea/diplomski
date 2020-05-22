public class Invoice implements Cloneable {
private String productDescription;
private int productQuantity;

public Invoice() {
}

public Invoice(Invoice copy) {
    productDescription = copy.productDescription;
    productQuantity = copy.productQuantity;
}

public Object clone() throws CloneNotSupportedException {
    return new Invoice(this);
}