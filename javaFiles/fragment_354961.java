@Entity
public Transaction {
...
@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinColumn(name = "transaction_id")
private List<GroceryItem> items = new ArrayList<>();
...
}