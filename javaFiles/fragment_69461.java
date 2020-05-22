class ProductResult {
    private int        onlineCount;
    private int        instoreCount;
    private BigDecimal minCost;
    private BigDecimal maxCost;

    public void add(Product product) {
        if (product.getPurchaseType() == Product.PurchaseType.ONLINE)
            this.onlineCount++;
        else if (product.getPurchaseType() == Product.PurchaseType.INSTORE)
            this.instoreCount++;
        if (this.minCost == null || product.getCost().compareTo(this.minCost) < 0)
            this.minCost = product.getCost();
        if (this.maxCost == null || product.getCost().compareTo(this.maxCost) > 0)
            this.maxCost = product.getCost();
    }
    public ProductResult merge(ProductResult that) {
        this.onlineCount += that.onlineCount;
        this.instoreCount += that.instoreCount;
        if (this.minCost == null || that.minCost.compareTo(this.minCost) < 0)
            this.minCost = that.minCost;
        if (this.maxCost == null || that.maxCost.compareTo(this.maxCost) > 0)
            this.maxCost = that.maxCost;
        return this;
    }
    @Override
    public String toString() {
        return "[online: " + this.onlineCount +
              ", instore: " + this.instoreCount +
              ", min: " + this.minCost +
              ", max: " + this.maxCost + "]";
    }
    public int getOnlineCount() {
        return this.onlineCount;
    }
    public int getInstoreCount() {
        return this.instoreCount;
    }
    public BigDecimal getMinCost() {
        return this.minCost;
    }
    public BigDecimal getMaxCost() {
        return this.maxCost;
    }
}