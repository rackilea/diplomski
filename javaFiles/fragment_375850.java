@Entity
public class Photo{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Integer photo_id;

    String photoName;

    @ManyToOne(targetEntity=Album.class)
    @JoinColumn(name="album_id")
    Album album;

}