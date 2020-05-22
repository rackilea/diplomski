public class ProductTemplate {
    protected Item getItemFromShop() {
        processItemPrice();
        callOrderSummary();
        return null;
    }

    protected void processItemPrice() {
//        Do some logic....
        System.out.println("ProductTemplate.processItemPrice()");
    }

    protected void callOrderSummary() {
//        Do some logic....
        System.out.println("ProductTemplate.callOrderSummary()");
    }

}

public class ImportedProduct extends ProductTemplate {

    @Override
    protected Item getItemFromShop() {
        return super.getItemFromShop(); // When i call this super method, they will use the processItemPrice() from the implementation
    }

    @Override
    protected void processItemPrice() {
//        Do another logic....
        System.out.println("ImportedProduct.processItemPrice()");
    }

    public static void main(String[] args) {
        new ImportedProduct().getItemFromShop();
    }
}