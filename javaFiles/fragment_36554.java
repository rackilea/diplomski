@Table(name = "JOB")
public class Job implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO) //or some other strategy
    private Long id;

    @OneToOne()
    @JoinColumn(name = "preceder_id")
    private Job previousJob;
}