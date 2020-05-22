public class Customer {

    String personName;
    List<String> itemsBought;

    public Customer(String personName) {
        this.personName = personName;
        itemsBought = Collections.emptyList();
    }

    public void setItemsBought(List<String> itemsBought) {
        this.itemsBought = itemsBought;
    }

    @Override
    public String toString() {
        return personName + " bought " + itemsBought;
    }

}