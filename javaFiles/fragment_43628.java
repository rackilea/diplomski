class ShopingCartEntry {

    public float price;
    public int quantity;

    public float getTotalPrice() {
        return price * quantity;
    }


    // either add a constructor or getter / setter to initialize price & quantity
}

class ShopingCartContents {

    public ShopingCartEntry[] items; // instead of an array you should have a parameterized constructor 

    public float getTotalPrice() { // pass a list of ShopingCartEntry
        float totalPrice = 0;
        for (ShopingCartEntry item : items) {
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }



}

class Order {

    private ShopingCartContents cart; 
    private float salesTax;

    // add a List<ShopingCartEntry> object

    public Order(ShopingCartContents cart, float salesTax) {
        this.cart = cart;
        this.salesTax = salesTax;
        // add the object to the orderList - new list
    }

    public float orderTotalPrice() {
        return cart.getTotalPrice() * (1.0f + salesTax); // pass the list as a parameter to cart.getTotalPrice()
    }

    // add a mtheod to add contents / objects to the list - name addContents to the list
}

public class LooseCoupling {

    public static void main(String[] args) {
        /* 1. create an object of order class - passing the item and price
         2. run a loop to add object to the order list method - addContents
         3. finally you should call oreder.orderTotalPrice() */

         // secondly add another method to remove objects from list

    }
}