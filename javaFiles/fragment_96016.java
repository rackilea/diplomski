public class ExtensionAttributes {

    @SerializedName("stock_item")
    @Expose
    private StockItem stockItem;

    public StockItem getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }

}