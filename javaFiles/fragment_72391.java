@Entity
public class MainClass {

    @OneToMany
    @JoinTable(name = "TheViewName", 
        joinColumns = @JoinColumn(name = "id", insertable = false, updatable= false), 
        inverseJoinColumns = @JoinColumn(name = "other_id", insertable = false, 
            updatable = false))
    private List<OtherEntity> otherEntities;
}