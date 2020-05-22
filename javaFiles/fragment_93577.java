public abstract class Item {
  final Long id;
  final String name;
  final Long value;

  public Item(final Long id, final Long name, final Long value) {
    this.id = id;
    this.name = name;
    this.value = value;
  }

  String getName() {
    return name;
  }
  // other getters and setters
}

public class SupermarketItem extends Item {
  public SupermarketItem(final Long id, final Long name, final Long value) {
    super(id, name, value);
  }
}

public class StoreItem extends Item {
  public StoreItem(final Long id, final Long name, final Long value) {
    super(id, name, value);
  }
}