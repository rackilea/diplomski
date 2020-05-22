class Product {
    public enum PurchaseType { ONLINE, INSTORE }

    private final String       code;
    private final PurchaseType purchaseType; 
    private final BigDecimal   cost;

    public Product(String code, PurchaseType purchaseType, String cost) {
        this.code = code;
        this.purchaseType = purchaseType;
        this.cost = new BigDecimal(cost);
    }
    public String getCode() {
        return this.code;
    }
    public PurchaseType getPurchaseType() {
        return this.purchaseType;
    }
    public BigDecimal getCost() {
        return this.cost;
    }
}