@AttributeOverride(name="id", column=@Column(name="EMP_ID"))
@Entity
public class MyClassChild extends SuperClass {

  private String some column;
  ...
}