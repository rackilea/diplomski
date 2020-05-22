@OneToMany(cascade = CascadeType.ALL)
@JoinTable(name="CREATURE_EQUIPPED_ITEM")
private List<Item> equippedItems;

@OneToMany(cascade = CascadeType.ALL)
@JoinTable(name="CREATURE_INVENTORY_ITEM")
private List<Item> itemsInBackpack;