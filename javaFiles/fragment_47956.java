public class MemberAttributePk implements Serializable {
    protected Long memberId;
    protected String name;

    public MemberAttributePk() {}

    // get & set
}

@Entity
@IdClass(MemberAttributePk.class)
public class MemberAttribute {
    @Id
    @Column(name = "member_id")
    protected Long memberId;

    @Id
    @Column(name = "name")
    protected String name;

    @ManyToOne 
    @JoinColumn(name="member_id")
    protected Member member;

    private String value;

    public MemberAttribute() {}

    // get & set
}