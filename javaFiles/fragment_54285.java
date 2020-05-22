@Entity
@Audited
@AuditOverrides({
  @AuditOverride(forClass = SuperClass.class, isAudited = true),
  @AuditOverride(forClass = SuperClass.class, name = "list", isAudited = false)
})
public class Entity1 extends SuperClass {
  // just put your entity1 attributes here, no need to duplicate anything
}

@Entity
@Audited
@AuditOverride(forClass = Item.class, isAudited = true)
public class Entity2 extends Item {
  // just put your entity2 attributes here, no need to duplicate anything
}