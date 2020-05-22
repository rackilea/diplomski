Object productPriceLock = new Object(); 
.............

public void run() {
    synchronized (productPriceLock) {
        product.add(i1);
        price.add(i2);
    }
}