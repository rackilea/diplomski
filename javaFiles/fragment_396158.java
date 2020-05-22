@Embeddable
public class PhotosUsersEntityKey implements Serializable {

    @Column(name="PROPERTY_ID", nullable=false)
    private Integer    userId;

    @Column(name="BILL_ID", nullable=false)
    private Integer    photoId;

//getters+setters
}