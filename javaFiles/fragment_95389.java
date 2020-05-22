private static class OrderData {

    private final String productName;
    private final String productId;
    private final String clientId;
    private final String date;

    public OrderData(String csvLine) {

        String[] data = csvLine.split("\t");

        this.productName = data[0];
        this.productId = data[1];
        this.clientId = data[2];
        this.date = data[3];

    }

    public String getProductName() {
        return productName;
    }

    public String getProductId() {
        return productId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getDate() {
        return date;
    }
}