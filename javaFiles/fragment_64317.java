@Entity
public class Event {
    @Embedded
    @AttributeOverride(name="code", column=@Column(name="manager_code"))
    public Person manager;

    @Embedded
    @AttributeOverride(name="code", column=@Column(name="operator_code"))
    public Person operator;

    //...
}