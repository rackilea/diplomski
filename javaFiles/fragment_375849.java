@Entity
public class Album {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Integer albumId;

    String albumName;

    @OneToMany(targetEntity=Photo.class,mappedBy="album",cascade={CascadeType.ALL},orphanRemoval=true)
    Set<Photo> photos = new HashSet<Photo>();
}