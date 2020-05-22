import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StockItem {

    @SerializedName("item_id")
    @Expose
    private Integer itemId;
    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("stock_id")
    @Expose
    private Integer stockId;
    @SerializedName("qty")
    @Expose
    private Integer qty;
    @SerializedName("is_in_stock")
    @Expose
    private Boolean isInStock;
    @SerializedName("is_qty_decimal")
    @Expose
    private Boolean isQtyDecimal;
    @SerializedName("show_default_notification_message")
    @Expose
    private Boolean showDefaultNotificationMessage;
    @SerializedName("use_config_min_qty")
    @Expose
    private Boolean useConfigMinQty;
    @SerializedName("min_qty")
    @Expose
    private Integer minQty;
    @SerializedName("use_config_min_sale_qty")
    @Expose
    private Integer useConfigMinSaleQty;
    @SerializedName("min_sale_qty")
    @Expose
    private Integer minSaleQty;
    @SerializedName("use_config_max_sale_qty")
    @Expose
    private Boolean useConfigMaxSaleQty;
    @SerializedName("max_sale_qty")
    @Expose
    private Integer maxSaleQty;
    @SerializedName("use_config_backorders")
    @Expose
    private Boolean useConfigBackorders;
    @SerializedName("backorders")
    @Expose
    private Integer backorders;
    @SerializedName("use_config_notify_stock_qty")
    @Expose
    private Boolean useConfigNotifyStockQty;
    @SerializedName("notify_stock_qty")
    @Expose
    private Integer notifyStockQty;
    @SerializedName("use_config_qty_increments")
    @Expose
    private Boolean useConfigQtyIncrements;
    @SerializedName("qty_increments")
    @Expose
    private Integer qtyIncrements;
    @SerializedName("use_config_enable_qty_inc")
    @Expose
    private Boolean useConfigEnableQtyInc;
    @SerializedName("enable_qty_increments")
    @Expose
    private Boolean enableQtyIncrements;
    @SerializedName("use_config_manage_stock")
    @Expose
    private Boolean useConfigManageStock;
    @SerializedName("manage_stock")
    @Expose
    private Boolean manageStock;
    @SerializedName("low_stock_date")
    @Expose
    private Object lowStockDate;
    @SerializedName("is_decimal_divided")
    @Expose
    private Boolean isDecimalDivided;
    @SerializedName("stock_status_changed_auto")
    @Expose
    private Integer stockStatusChangedAuto;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Boolean getIsInStock() {
        return isInStock;
    }

    public void setIsInStock(Boolean isInStock) {
        this.isInStock = isInStock;
    }

    public Boolean getIsQtyDecimal() {
        return isQtyDecimal;
    }

    public void setIsQtyDecimal(Boolean isQtyDecimal) {
        this.isQtyDecimal = isQtyDecimal;
    }

    public Boolean getShowDefaultNotificationMessage() {
        return showDefaultNotificationMessage;
    }

    public void setShowDefaultNotificationMessage(Boolean showDefaultNotificationMessage) {
        this.showDefaultNotificationMessage = showDefaultNotificationMessage;
    }

    public Boolean getUseConfigMinQty() {
        return useConfigMinQty;
    }

    public void setUseConfigMinQty(Boolean useConfigMinQty) {
        this.useConfigMinQty = useConfigMinQty;
    }

    public Integer getMinQty() {
        return minQty;
    }

    public void setMinQty(Integer minQty) {
        this.minQty = minQty;
    }

    public Integer getUseConfigMinSaleQty() {
        return useConfigMinSaleQty;
    }

    public void setUseConfigMinSaleQty(Integer useConfigMinSaleQty) {
        this.useConfigMinSaleQty = useConfigMinSaleQty;
    }

    public Integer getMinSaleQty() {
        return minSaleQty;
    }

    public void setMinSaleQty(Integer minSaleQty) {
        this.minSaleQty = minSaleQty;
    }

    public Boolean getUseConfigMaxSaleQty() {
        return useConfigMaxSaleQty;
    }

    public void setUseConfigMaxSaleQty(Boolean useConfigMaxSaleQty) {
        this.useConfigMaxSaleQty = useConfigMaxSaleQty;
    }

    public Integer getMaxSaleQty() {
        return maxSaleQty;
    }

    public void setMaxSaleQty(Integer maxSaleQty) {
        this.maxSaleQty = maxSaleQty;
    }

    public Boolean getUseConfigBackorders() {
        return useConfigBackorders;
    }

    public void setUseConfigBackorders(Boolean useConfigBackorders) {
        this.useConfigBackorders = useConfigBackorders;
    }

    public Integer getBackorders() {
        return backorders;
    }

    public void setBackorders(Integer backorders) {
        this.backorders = backorders;
    }

    public Boolean getUseConfigNotifyStockQty() {
        return useConfigNotifyStockQty;
    }

    public void setUseConfigNotifyStockQty(Boolean useConfigNotifyStockQty) {
        this.useConfigNotifyStockQty = useConfigNotifyStockQty;
    }

    public Integer getNotifyStockQty() {
        return notifyStockQty;
    }

    public void setNotifyStockQty(Integer notifyStockQty) {
        this.notifyStockQty = notifyStockQty;
    }

    public Boolean getUseConfigQtyIncrements() {
        return useConfigQtyIncrements;
    }

    public void setUseConfigQtyIncrements(Boolean useConfigQtyIncrements) {
        this.useConfigQtyIncrements = useConfigQtyIncrements;
    }

    public Integer getQtyIncrements() {
        return qtyIncrements;
    }

    public void setQtyIncrements(Integer qtyIncrements) {
        this.qtyIncrements = qtyIncrements;
    }

    public Boolean getUseConfigEnableQtyInc() {
        return useConfigEnableQtyInc;
    }

    public void setUseConfigEnableQtyInc(Boolean useConfigEnableQtyInc) {
        this.useConfigEnableQtyInc = useConfigEnableQtyInc;
    }

    public Boolean getEnableQtyIncrements() {
        return enableQtyIncrements;
    }

    public void setEnableQtyIncrements(Boolean enableQtyIncrements) {
        this.enableQtyIncrements = enableQtyIncrements;
    }

    public Boolean getUseConfigManageStock() {
        return useConfigManageStock;
    }

    public void setUseConfigManageStock(Boolean useConfigManageStock) {
        this.useConfigManageStock = useConfigManageStock;
    }

    public Boolean getManageStock() {
        return manageStock;
    }

    public void setManageStock(Boolean manageStock) {
        this.manageStock = manageStock;
    }

    public Object getLowStockDate() {
        return lowStockDate;
    }

    public void setLowStockDate(Object lowStockDate) {
        this.lowStockDate = lowStockDate;
    }

    public Boolean getIsDecimalDivided() {
        return isDecimalDivided;
    }

    public void setIsDecimalDivided(Boolean isDecimalDivided) {
        this.isDecimalDivided = isDecimalDivided;
    }

    public Integer getStockStatusChangedAuto() {
        return stockStatusChangedAuto;
    }

    public void setStockStatusChangedAuto(Integer stockStatusChangedAuto) {
        this.stockStatusChangedAuto = stockStatusChangedAuto;
    }

}