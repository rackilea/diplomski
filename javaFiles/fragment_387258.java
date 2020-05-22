@Embeddable
public class UseCaseStatusId implements Serializable {

    //@JoinColumn(name = "trackingId", updatable = false, nullable = false) <- prob not required
    private long tracking;

    @Column(name = "status")
    private String status;

    //implement equals() and hashcode() : https://en.wikibooks.org/wiki/Java_Persistence/Identity_and_Sequencing#Embedded_Id
}