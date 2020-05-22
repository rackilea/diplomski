class ShoppingListItems(){

  @Id
  private String id;
  private Long shoppingListId;
  private Long itemId;

  public ShoppingListItems(Long shoppingListId, Long itemId) {
    this.id = shoppingListId.toString() + "-" + itemId.toString();
    this.shoppingListId = shoppingListId;
    this.itemId = itemId;
  }

  public String getId() {
    return id;
  }

  public static void addItemToList(Long shoppingListId, Long itemId, DAO dao) {
        // add shopping list and itemsr IDs to the ShoppingListItems 'join' table
        ShoppingListItems record = new ShoppingListItems(shoppingListId, itemId);
        dao.ofy().put(record);   
  }