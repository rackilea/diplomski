@Entity
@Audited
public class AnotherAuditedEntity {
    @Audited
    AuditedEntity e;
    ...
}