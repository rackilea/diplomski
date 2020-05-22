@Entity
public abstract class Compound<T extends Containable> {


    @OneToMany(fetch = FetchType.EAGER, mappedBy="compound",
        targetEntity=Containable.class, cascade = CascadeType.ALL)      
    private Set<T> containables = new HashSet<T>();

}

@Entity 
public abstract class Containable<T extends Compound> {     

    @ManyToOne(optional=true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private T compound;
}