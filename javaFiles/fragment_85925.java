@Audited
@Entity
@EntityListeners(AuditingEntityListener.class)
public class UserInfo extends AuditInfo {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "userInfo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserAddress> addresses;

}