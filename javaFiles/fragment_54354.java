@Entity
public class VitalStats 
{
    @Id @Column(name="vitalstats_id") Long id;

    @MapsId 
    @OneToOne(mappedBy = "vitalStats")
    @JoinColumn(name = "vitalstats_id")   //same name as id @Column
    private Person person;

    private String stats;
}