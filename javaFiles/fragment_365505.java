@Entity
@AttributeOverride(name="id", column=@Column(name="ABC_ID"))
@Table(name = "ABC",schema = "XYZ" )
public class SaveData extends EntityClass {

    @Column(name = "ABC1_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    private int abc1_id;

    @Column(name = "DATA", nullable = true, insertable = true, updatable = true, precision = 0)
    private String data;    
}