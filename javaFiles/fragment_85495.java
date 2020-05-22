@Entity
@Table(name="Map")
public class Map implements Serializable {

  private static final long serialVersionUID = -5527566248002296042L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer mapId;

  @OneToMany(mappedBy = "mapId", cascade = CascadeType.ALL)
  private List<Car> cars;

  @Column(name = "address")
  private String address;

  public Integer getMapId() {
     return mapId;
  }

  public void setMapId(Integer mapId) {
     this.mapId = mapId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  } 
  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
      this.cars= cars;
  }
}