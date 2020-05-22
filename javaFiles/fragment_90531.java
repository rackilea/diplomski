@Entity
@Table(name="RECIPIENTS")
abstract class Item {
  ...
}

@Entity
  public class InvoiceItem extends Item {
}

@Entity
  public class CatalogueItem extends Item {
}


class Invoice {
  @OneToMany(fetch=FetchType.EAGER, orphanRemoval = true, cascade = { javax.persistence.CascadeType.ALL })
  @Fetch(FetchMode.JOIN)
  @JoinColumn(name="RELATED_ITEM_ID", nullable=false)
  Set<InvoiceItem> items;
}

class Catalogue {
  @OneToMany(fetch=FetchType.EAGER, orphanRemoval = true, cascade = { javax.persistence.CascadeType.ALL })
  @Fetch(FetchMode.JOIN)
  @JoinColumn(name="RELATED_ITEM_ID", nullable=false)
  Set<CatalogueItem> items;
}