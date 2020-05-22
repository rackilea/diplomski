@Entity
@Table(name = "polling")
public class Polling extends DomainIdObject {
    ...
    @OneToMany(mappedBy="polling")
    private List<PollingSchedule> variants;
    ...
}