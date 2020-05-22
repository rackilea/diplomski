import java.util.HashMap;
import java.util.Map;

class RadixNode {
    private Map<Character, RadixNode> children;
    private Customer customer;

    public RadixNode(){
        this.children = new Map<Character, RadixNode>();
        this.Customer = NULL;
    }
    Map<Character, RadixNode> getChildren() {
        return children;
    }
    boolean hasCustomer() {
        return this.customer != NULL;
    }
    Customer getCustomer() {
        return customer;
    }
    void setCustomer(Customer customer) {
        this.customer = customer;
    }
}