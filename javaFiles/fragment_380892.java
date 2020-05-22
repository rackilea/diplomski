@Data 
@Entity 
@JsonSnakeCase
public class WareHouse {

  @Id
  @GeneratedValue
  private long id;

  @Column(unique = true)
  private String fcId;

  @Enumerated(EnumType.STRING)
  private FCStatus status;

  @OneToMany(mappedBy = "warehouse", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  private List<WorkingHours> workingHours;

  @Enumerated(EnumType.STRING)
  private IntegrationType integrationType;
}