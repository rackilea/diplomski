public interface ItemInterface {
  String getName();
}

public abstract class AbstractItem implements ItemInterface {
}

public class ItemA extends AbstractItem {
  public String getName() {
    return "ItemA";
  }
}

// ItemB same as ItemA

public interface EntityInterface {
  Set<? extends AbstractItem> getItems();
}

@NoArgsConstructor
@AllArgsConstructor
@Data
@With
public class EntityA implements EntityInterface {
  private Set<ItemA> items;
}

// EntityB same as EntityA, but with Set of ItemB