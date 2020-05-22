@Entity
public class Experiment extends Observable {
    //...

    @OneToMany(mappedBy = "experiment")
    private Set<Experimenter> experimenters = new HashSet<>();

    //...
} 

@Entity
public class Experimenter extends Observer {
    //...

    @ManyToOne
    private Experiment experiment;

    //...
}