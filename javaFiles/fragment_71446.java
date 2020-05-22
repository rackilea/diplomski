@Entity
public class EntityC {
  @Id
  private long id;
  ...
  @OneToMany(mappedBy="entityC")
  private List<JoinTable> entityDs;
  ...
}

@Entity
public class EntityD {
  @Id
  private long id;
  ...
  @OneToMany(mappedBy="entityD")
  private List<JoinTable> entityCs;
  ...
}