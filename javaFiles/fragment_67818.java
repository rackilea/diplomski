@Entity
@Table(name = "schooltier")
public class SchoolTier {

@Id
@GeneratedValue
private Integer id;

// Pojo's
@Size(min = 0, message = " must be at least 4 characters!")
private String CampusImprovement;

//getter/setter 
}