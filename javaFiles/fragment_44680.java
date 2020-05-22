@Entity
public class MyEntity {

    @Id
    private String id;

    @Column(nullable = false)
    @NotNull
    private Integer size;

    public MyEntity(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
         this.size = size;
    }
}