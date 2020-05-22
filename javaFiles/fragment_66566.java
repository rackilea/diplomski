@Entity
@Table(name="event")
public class MyEvent {
    @Id
    int id;

    // what mapping should go here?
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "prodgroup_id", insertable = true, updatable = true)
    Prodgroup prodgroup;

    // what mapping should go here?
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "errandtype_id", insertable = true, updatable = true)
    ErrandType errandtype;
} 

@Entity
public class Prodgroup {
    @Id
    private String prodgroup;
}

@Entity
public class ErrandType {
    @Id
    private String errandtype;
}