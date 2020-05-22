public class CustomListAdapter {
    private String ItemName;
    private String Quantity;
    private String SerialNo;
    private String SupplierName;
    private String SupplierEmail;
    private String SupplierPhone;

    public CustomListAdapter() {}

    public CustomListAdapter(String itemName, String quantity, String serialNo, String supplierName, String supplierEmail, String supplierPhone) {
        ItemName = itemName;
        Quantity = quantity;
        SerialNo = serialNo;
        SupplierName = supplierName;
        SupplierEmail = supplierEmail;
        SupplierPhone = supplierPhone;
    }

    @PropertyName("ItemName")
    public String getItemName() { return ItemName; }
    @PropertyName("Quantity")
    public String getQuantity() { return Quantity; }
    @PropertyName("SerialNo")
    public String getSerialNo() { return SerialNo; }
    @PropertyName("SupplierName")
    public String getSupplierName() { return SupplierName; }
    @PropertyName("SupplierEmail")
    public String getSupplierEmail() { return SupplierEmail; }
    @PropertyName("SupplierPhone")
    public String getSupplierPhone() { return SupplierPhone; }
}