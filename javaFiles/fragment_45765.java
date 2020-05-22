@Entity
@Table(name = "assignment")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Assignment extends BaseEntity {

    @Id
    @Column(name = "id")
    @Type(type = "pg-uuid")
    @NotTracked
    private UUID id;

    @Column(name="policy_id")
    private UUID policyID;
}