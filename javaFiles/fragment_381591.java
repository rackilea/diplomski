@Entity
@Table(name = "doctor")
public class Doctor {

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "doctor_service", joinColumns = { @JoinColumn(name = "doctor_id", nullable = false) },
            inverseJoinColumns = { @JoinColumn(name = "service_id", nullable = false) })
    @JsonView(Views.Doctors.class)
    private Set<Service> services;
}