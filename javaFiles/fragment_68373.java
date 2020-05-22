@Entity
class EntityA  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public EntityA() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

@Entity
class EntityB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public EntityB() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}