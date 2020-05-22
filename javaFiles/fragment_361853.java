@Entity
@Table(name="Album")
public class Album {
    @Id
    @Column(name="id")
    private Long id;
    @OneToMany(targetEntity = AlbumTag.class, mappedBy = "album")
    private List<AlbumTag> albumTags;

    //getter and setter
}

@Entity
@Table(name="Tag")
public class Tag {
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="category")
    private String category;

    //getter and setter
}

@Entity
@Table(name="AlbumTag")
public class AlbumTag{
    @Id
    @Column(name="id")
    private Long id;
    @ManyToOne(optional = false, targetEntity = Album.class)
    @JoinColumn(name = "id", referencedColumnName="id", insertable = false, updatable = false)
    private Album album;
    @ManyToOne(optional = false, targetEntity = Tag.class)
    @JoinColumn(name = "id", referencedColumnName="id", insertable = false, updatable = false)
    private Tag tag;

    //getter and setter
}