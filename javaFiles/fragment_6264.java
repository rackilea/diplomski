@Entity
@Table(name="sales.jobs")
public class Job {
    ...
    @OneToMany(cascade=CascadeType.ALL,orphanRemoval=true, fetch=FetchType.LAZY)
    @JoinTable(name="sales.jobs_shipments",
           joinColumns = @JoinColumn(name="fk_jobid", referencedColumnName="pk_jobid"),
           inverseJoinColumns = @JoinColumn(name="fk_shipmentid", referencedColumnName="pk_shipmentid"))
    private List<Shipment> jobShipments = new ArrayList<Shipment>();
}