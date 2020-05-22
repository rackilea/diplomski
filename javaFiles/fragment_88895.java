@Entity
@Table(name = "polling_schedule")
public class PollingSchedule extends DomainIdObject {

    @ManyToOne
    @JoinColumn(name = "polling_id")
    private Polling polling;
    ...
}