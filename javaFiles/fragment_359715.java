@Entity
@Table(name = "my_entities")
public class MyEntity {
    //...

    private MyData data;
}

@Embeddable
public class MyData {
    private String value;
}