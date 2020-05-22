public class CartModel {
    public float totalAmount;
    public int products;

    public void addToCart(float productPrice) {
        products++;
        totalAmount += productPrice;
    }
}