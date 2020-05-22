@FilterDef(name="baseStatus")
@Filter(name="baseStatus", condition= "Status = 'A'")
@MappedSuperclass
public abstract class BaseModel {

    @Column(name = "Status", insertable = false)
    private String status;

    // getters and setters...
}

@Entity
@Table(name = "A")
public class A extends BaseModel {
    @OneToMany()
    @Filter(name="baseStatus", condition= "Status = 'A'")
    private List<B> bs = new ArrayList<B>(0);
// other model properties
}

@Entity
@Table(name = "B")
public class B extends BaseModel {
// model properties
}