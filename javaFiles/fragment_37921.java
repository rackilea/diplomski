@Entity
@Table(name = "Profiles_table")
public class Profiles {

@Id
@Column(name = "profile_ID", updatable = false, nullable = false)
@GeneratedValue(strategy = GenerationType.AUTO)
private int                                 id;

@Column(length = 16777210)
private final HashMap<String, Set<String>>  AllProfiles;