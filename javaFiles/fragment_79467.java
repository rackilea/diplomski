@Embeddable
class Base implements Serializable {

    @Column(name="column1")
    protected String column1;

}

@Entity
@Inheritance(strategy.InheritanceType.JOINED)
@DiscriminatorColumn(name="type")
@Table(name="parent")
class Parent {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Embdedded
    private Base base;

}

@Entity
@DiscriminatorValue("val")
@Table(name="child")
@PrimaryKeyJoinColumn(name="id")
class Child extends Parent {

    // other columns
    ...
}