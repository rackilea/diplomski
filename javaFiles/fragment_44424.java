@Entity
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idarea")
    private Long idArea;

    @Column(name="area_name")
    private String areaName;

    @OneToOne(fetch=FetchType.LAZY, mappedBy="area")
    private User user;

    public Long getIdArea() {
        return idArea;
    }

    public void setIdArea(Long idArea) {
        this.idArea = idArea;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}