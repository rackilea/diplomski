public class Item implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item") //non-owning side
    public Set<ItemCost> getCosts() {
        return costs;
    }
}