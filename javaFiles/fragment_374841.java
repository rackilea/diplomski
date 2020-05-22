private static OtherItem OtherItem1;

public static void createOtherItem() {
    // existing code here, down to the object creation...

    // it's already declared, so you don't need to specify the type again
    OtherItem1 = new OtherItem(itemName, price, id, stock, department, details);
    OtherItem1.getItemName();
}