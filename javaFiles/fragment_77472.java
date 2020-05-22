public class Shop {
    private final String id; // Id of this shop.
    private final ShopOwner owner; // Owner of this shop.
    public Shop(String id, ShopOwner owner) {
        this.id = id;
        this.owner = owner;
    }
    public String getId() { return id; }

    // Overwrite equals and hashcode to allow using Shop as a key in a HashMap (only necessary if you want to enforce uniqueness of a ShopOwner's shops by maintaining a ShopOwner's owned shops using a Map).
    // We simply define equality based on id equality and rely on String.hashCode() (note that this will have to be changed if you want to add additional properties and define equality based on those):
    @Override
    public boolean equals(Object o) {
        return o instanceof Shop && o.toString().equals(this.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
    @Override
    public String toString() {
        return id;
    }
    // Other properties etc.
}