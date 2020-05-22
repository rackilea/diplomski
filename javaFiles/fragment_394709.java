@Entity
@IdClass(ClassBPK.class)
public class ClassB {

    @Id
    private Integer pk1;
    @Id
    private Integer pk2;

    @ManyToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name = "pk1", referencedColumnName = "pk1"),
        @PrimaryKeyJoinColumn(name = "pk2", referencedColumnName = "pk2")
    })
    private ClassA a;

    @Id
    private Integer pk3;

    //...
}