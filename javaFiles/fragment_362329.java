@javax.persistence.Table(name = "project")
@Table(appliesTo = "project" ,indexes = @Index(columnNames = "user", name = "user_index"))
@Entity
public class Project
{
 ..