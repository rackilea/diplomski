@Embeddable
public class MemberAttributePk implements Serializable {
    @Column(name = "member_id")
    protected Long memberId;
    @Column(name = "name")
    protected String name;

    public MemberAttributePk() {}

    // get & set
}

@Entity
public class MemberAttribute {

    @EmbeddedId
    protected MemberAttributePk memberAttributePk;

    @ManyToOne 
    @JoinColumn(name="member_id")
    protected Member member;

    private String value;

    public MemberAttribute() {}

    // get & set
}