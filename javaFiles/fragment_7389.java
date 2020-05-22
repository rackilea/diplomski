@Entity
public class Actor extends AbstractBusinessObject{

    @ManyToMany(mappedBy = "cast")
    private Set<Movie> movies;

    // setters and getters

    @PreRemove
    private void removeActorFromMovies() {
        //Executed before the entity manager remove operation is actually 
        // executed or cascaded. This call is synchronous with the remove operation.

    }

}