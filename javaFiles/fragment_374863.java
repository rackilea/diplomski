@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"quasiUniqueSid","ownerEntity_id"}), name="myUniqueConstraint")
public class OwnedEntity {
    ...
    String quasiUniqueSid;
    @ManyToOne
    OwnerEntity ownerEntity;
    ...
}