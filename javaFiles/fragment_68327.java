@Entity
@Table(name = "MY_TABLE")
public class MyEntity {

@Id
@GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
@GenericGenerator(name = "seq", strategy="increment")
@Column(name = "MY_TABLE_ID")
private Integer myTableId;

@Column(name = "MY_TABLE_NM")
private String myTableName;

//Getters Setters
}