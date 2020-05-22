@Entity
@Table(name = "school")
public class School implements Comparable<School>{

@Transient
private int functionValue;

@Id
@GeneratedValue
private Integer id;

@Size(min = 3, message = "Name must be at least 3 characters!")
@UniqueUsername(message = "School Name already exists!")
@Column(length = 1000, unique = true)
private String name;

//This will create a foreign key of SchoolTier table.
@JoinColumn(name = "school_tier_id_1")
@OneToOne
private SchoolTier schoolTier1;

//This will create a foreign key of SchoolTier table.
@JoinColumn(name = "school_tier_id_2")
@OneToOne
private SchoolTier schoolTier2 = new SchoolTier();

//This will create a foreign key of SchoolTier table.
@JoinColumn(name = "school_tier_id_3")
@OneToOne
private SchoolTier schoolTier3;
//their getter/setter
}