@Table( name ="tablename " , uniqueConstraints={
       @UniqueConstraint(name="myconst", columnNames={"myProp"})
   })

public class MyEntity {

@OneToOne(fetch = FetchType.EAGER, cascade =     CascadeType.ALL, orphanRemoval = true)
@JoinColumn(name="myProp")
private MyPropertyClass myProperty;

}