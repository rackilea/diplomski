@Entity
@Audited
@EntityListeners(AuditingEntityListener.class)
public class UserAddress extends AuditInfo {

    @Id
    @GeneratedValue
    private Long addressId;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private UserInfo userInfo;

    @Column
    private Long no;

    @Column
    private String street;

}