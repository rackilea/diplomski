public class GroceryCounter  {

    private final DoubleProperty volume = new SimpleDoubleProperty();
    private final DoubleProperty price = new SimpleDoubleProperty();
    private  final DoubleBinding transactionFee;

    public GroceryCounter () {
        this.transactionFee = this.price.multiply(this.volume).multiply(0.0025);
    }



    public double getVolume() {
        return this.volume.get();
    }

    public DoubleProperty volumeProperty() {
        return this.volume;
    }

    public void setVolume(double volume) {
        this.volume.set(volume);
    }

    public double getPrice() {
        return this.price.get();
    }

    public DoubleProperty priceProperty() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public double getTransactionFee() {

            return this.transactionFee.getValue();
    }

    public DoubleBinding transactionFeeProperty() {
        return this.transactionFee;
    }
}