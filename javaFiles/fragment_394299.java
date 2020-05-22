public class CustomListAdapter {
    private String itemName, quantity, serialNo, supplierName, supplierEmail, supplierPhone;

    public CustomListAdapter() {}

    public CustomListAdapter(String itemName, String quantity, String serialNo, String supplierName, String supplierEmail, String supplierPhone) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.serialNo = serialNo;
        this.supplierName = supplierName;
        this.supplierEmail = supplierEmail;
        this.supplierPhone = supplierPhone;
    }

    public String getItemName() { return itemName; }
    public String getQuantity() { return quantity; }
    public String getSerialNo() { return serialNo; }
    public String getSupplierName() { return supplierName; }
    public String getSupplierEmail() { return supplierEmail; }
    public String getSupplierPhone() { return supplierPhone; }
}