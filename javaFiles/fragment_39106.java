@Entity
public class Person {
    @Id int id;
    @Basic String name;
    @Basic(fetch = FetchType.LAZY) String remark;
}