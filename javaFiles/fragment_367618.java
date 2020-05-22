public class Shipment {
    private int trackingCode;
    private int priority;
    private double shippingPrice;
    private double weight;
    private String originCity;
    private String destCity;
    private String trackingPage;

    public Shipment(int trackingCode, int priority, double shippingPrice, double weight, String originCity, String destCity, String trackingPage) {
        this.trackingCode = trackingCode;
        this.priority = priority;
        this.shippingPrice = shippingPrice;
        this.weight = weight;
        this.originCity = originCity;
        this.destCity = destCity;
        this.trackingPage = trackingPage;
    }

    public int getTrackingCode() {
        return trackingCode;
    }
}