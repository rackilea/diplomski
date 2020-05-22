public class Receipt {
    private List<LineItem> receiptItems;

    // ... 

    public void add(LineItem lineItem) {
        // be mindful of handling duplicates if needed
        receiptItems.add(lineItem); 
    }

}