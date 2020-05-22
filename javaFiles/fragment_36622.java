@Entity
public class Project extends BaseEntity {
  private String project_name;
  // other properties
}

@RepositoryRestResource
public interface ProjectRepo extends JpaRepository<User, Long> {}