@Entity
@Table(name = "service")
public class Service {

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "services")
    @JsonView(Views.Services.class)
    private Set<Doctor> doctors;

}