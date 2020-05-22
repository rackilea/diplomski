@Entity
@Table(name = "davt_compensation_service_relocation")
public class RelocationCompensation extends Compensation<RelocationCompensation> {

    @Valid
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phone_id")
    @ForeignKey(name = "FK_relocationCompensation_phone")
    private Phone phone = new Phone();

    @Valid
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    @ForeignKey(name = "FK_relocationCompensation_address")
    private Address address = new Address();

    //rest of properties, setters and getters, equals and hashcode overrides
}