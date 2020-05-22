@Entity
public class Item implements Serializable {

    @Id
    @GeneratedValue(generator = MyGenerator.generatorName)
    @GenericGenerator(name = MyGenerator.generatorName, strategy = "a.b.c.MyGenerator")
    private String id;

    // rest of the entity
}