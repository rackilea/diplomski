@Entity
@Table(name = "foo")
@SecondaryTable(name = "other_table", pkJoinColumns=@PrimaryKeyJoinColumn(name="id", referencedColumnName="FOO_ID"))
public class Foo {
    @Id
    @Column(name="FOO_ID")
    private String fooId;

    @Column(name="FOO_A")
    private String fooA;

    @Column(table="OtherTable", name="barCode")
    private String barCode;
}