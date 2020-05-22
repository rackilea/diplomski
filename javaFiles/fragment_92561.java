@Data
@Entity
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(
        mappedBy = "member"
    )        
    private List<PhoneEntity> phoneEntities;
}


@Data
@Entity
@Table(name = "phone")
public class PhoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY) // Or Eager 
    @JoinColumn(name = "member_id")
    private MemberEntity member;
}