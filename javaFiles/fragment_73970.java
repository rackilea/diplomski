@Entity
public class MainEntity {

    private Long id;

    private RelatedEntity relatedEntity

    //getters and setters and possible other methods
    @Id
    public Long getId() {
        return id;
    }

    @OneToMany
    public RelatedEntity getRelatedEntity(){
           return relatedEntity
    }

    //other methods etc
    ...
 }