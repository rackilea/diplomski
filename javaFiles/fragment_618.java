// Returns the item with no parent
private List<Item> searchParentlessItems();

// Returns the item with the given item as parent
private List<Item> searchItemChildren(Item item);

// Returns the children count
private Long countItemChildren(Item item);

// Build a SubMenu for the specified item
private SubMenu createSubMenu(Item item);

// Build a MenuItem for the specified item
private MenuItem createMenuItem(Item item);