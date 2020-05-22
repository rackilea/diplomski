public class Sito {

     // ...

     @ManyToMany
     @JoinTable(name="sito_user",
          joinColumns=@JoinColumn(name="sito_id", referencedColumnName="id"),
          inverseJoinColumns=@JoinColumn(name="user_id", referencedColumnName="id"))
    private List<User> users;

    @ManyToMany(mappedBy = "sitos")
    private List<Cluster> clusters;


    // getters + setters
}