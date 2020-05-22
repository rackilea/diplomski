public class ShoppingCart {

    private List<String> items;

    @ValidCollection(elementType=String.class, constraints={NotBlank.class})
    public List<String> getItems() { return items; }
    public void setItems(List<String> items) { this.items = items; }

}