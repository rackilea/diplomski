@Entity
public class Tag {
    @Id @GeneratedValue private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }   
    @ManyToMany private Set<Movie> movieTags;
    @ManyToMany private Set<Studio> studioTags;
    @ManyToMany private Set<Site> siteTags;

@Entity
public class Movie {
    @Id @GeneratedValue private int id;
    @ManyToMany(mappedBy="movieTags") private Set<Tag> tags;
    @ManyToOne private Studio studio;
    @ManyToOne private Site site;

@Entity
public class Site {
    @Id @GeneratedValue private int id;
    @ManyToMany(mappedBy="siteTags") private Set<Tag> tags;
    @OneToMany(mappedBy="site") private Set<Movie> movies;

@Entity
public class Studio {
    @Id @GeneratedValue private int id;
    @ManyToMany(mappedBy="studioTags") private Set<Tag> tags;
    @OneToMany(mappedBy="studio") private Set<Movie> movies;