@Entity
public class User {

    ...

    @ManyToOne
    private PrimaryAccount primaryAccount;

    @ManyToOne
    private SavingsAccount savingsAccount;

    @OneToMany(mappedBy="user")
    private List<Appointment> appointmentList;

    @OneToMany // you may add [mappedBy] if it's bidirectional
    private List<Recipient> recipientList;

    ...
}