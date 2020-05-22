public class User {

    // ...

    @ManyToMany(mappedBy="users")
    private List<Cluster> clusters;

    @ManyToMany(mappedBy="users")
    private List<Sito> sitos;

    // getters + setters


}