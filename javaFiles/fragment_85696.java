@Entity
public class Patient {

    @OneToMany(mappedBy = "patient", orphanRemoval = true)
    private Collection<Appointment> appointments;
}